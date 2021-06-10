package com.accelerator.automation.utilities;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


 
public class CommonUtilities {
 
    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUM_LIST="1234567890";
    
    private static final int RANDOM_STRING_LENGTH = 6;
     
    /**
     * This method generates random string
     * @return
     */
    public String generateRandomString(){
         
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    /**
     * randomstring with length
     * @param length
     * @return
     */
    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String candidateChars = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }
     
    /**
     * This method generates random numbers
     * @return int
     */
    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(NUM_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
    
    /**
     * This method generates random email
     * @return int
     */    
    public static String randomEmail() {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(10000);  
		return "username"+ randomInt +"@yopmail.com"; 
	}
    
    
    /**
     * This method introduces some wait time
     * @return int
     */  
    public void pause() throws InterruptedException 
	{
		Thread.sleep(4000);			
		
	}
    
     
   }