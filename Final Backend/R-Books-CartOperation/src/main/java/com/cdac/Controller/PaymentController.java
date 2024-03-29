package com.cdac.Controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.Service.CartService;
import com.cdac.dto.Cart;
import com.cdac.dto.PaytmDetailPojo;
import com.paytm.pg.merchant.PaytmChecksum;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentController {
	
	@Autowired
	private PaytmDetailPojo paytmDetailPojo;
	@Autowired
	private Environment env;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	 @PostMapping(value = "/submitPaymentDetail")
	    public ModelAndView getRedirect(@RequestBody int id) throws Exception {
		 ModelAndView modelAndView =null;
		 	Cart cart = cartService.getCartById(id);
		 	if(cart != null) {
	        modelAndView = new ModelAndView("redirect:" + paytmDetailPojo.getPaytmUrl());
	        Random rnd = new Random();
	        int number = rnd.nextInt(999999);

	        // this will convert any number sequence into 6 character.
	        String orderId =  String.format("%06d", number);

	        TreeMap<String, String> parameters = new TreeMap<>();
	        paytmDetailPojo.getDetails().forEach((k, v) -> parameters.put(k, v));
	        parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
	        parameters.put("EMAIL", env.getProperty("paytm.email"));
	        parameters.put("ORDER_ID", orderId);
	        parameters.put("TXN_AMOUNT", String.valueOf(cart.getBooks().getBookRent()));
	        parameters.put("CUST_ID", String.valueOf(cart.getUserId()));
	        String checkSum = getCheckSum(parameters);
	        parameters.put("CHECKSUMHASH", checkSum);
	        modelAndView.addAllObjects(parameters);
		 	}
	        return modelAndView;
	    }
	 
	 
	 @PostMapping(value = "/pgresponse")
	    public String getResponseRedirect(HttpServletRequest request, Model model) {

	        Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        String paytmChecksum = "";
	        for (Entry<String, String[]> requestParamsEntry : mapData.entrySet()) {
	            if ("CHECKSUMHASH".equalsIgnoreCase(requestParamsEntry.getKey())){
	                paytmChecksum = requestParamsEntry.getValue()[0];
	            } else {
	            	parameters.put(requestParamsEntry.getKey(), requestParamsEntry.getValue()[0]);
	            }
	        }
	        String result;

	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        try {
	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
	            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                    result = "Payment Successful";
	                } else {
	                    result = "Payment Failed";
	                }
	            } else {
	                result = "Checksum mismatched";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	        model.addAttribute("result",result);
	        parameters.remove("CHECKSUMHASH");
	        model.addAttribute("parameters",parameters);
	        return "report";
	    }

	    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
	        return PaytmChecksum.verifySignature(parameters,
	                paytmDetailPojo.getMerchantKey(), paytmChecksum);
	    }
	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return PaytmChecksum.generateSignature(parameters, paytmDetailPojo.getMerchantKey());
	}
	
}