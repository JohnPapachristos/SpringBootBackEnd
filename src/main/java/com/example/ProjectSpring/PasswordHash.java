package com.example.ProjectSpring;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {
	
	private String passwordToHash;
	
	private String generatedPassword = null;
	
	public void setPasswordToHash(String passwordToHash) {
		this.passwordToHash=passwordToHash;
	}
	
	public String getGeneratedPassword() {
		try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
		catch (java.lang.NullPointerException e) 
        {
            e.getLocalizedMessage();
        }
		return generatedPassword;
    }
}
