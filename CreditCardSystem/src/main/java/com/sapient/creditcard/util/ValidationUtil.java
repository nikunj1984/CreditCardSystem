package com.sapient.creditcard.util;

public class ValidationUtil {

	/**
	 * Method to validate credit card based on Luhn 10 alogortithm
	 * @param number
	 * @return
	 */
	public static boolean isValidCreditCardNumber(String cardNo){
		if(cardNo.length()>19) return false;
		
		int nDigits = cardNo.length();
		 
	    int nSum = 0;
	    boolean isSecond = false;
	    for (int i = nDigits - 1; i >= 0; i--)
	    {
	 
	        int d = cardNo.charAt(i) - '0';
	 
	        if (isSecond == true) {	        	
	            d = d * 2;
	            if(d>9) {
	            	d = d / 10 + d%10;
	            }
	        }	 
	        
	        nSum = nSum + d;
	        	 
	        isSecond = !isSecond;
	    }
	    return (nSum % 10 == 0);
	}
	 
	   public static void main(String[] args) {
		System.out.println(isValidCreditCardNumber("79927398713"));
	}
}
