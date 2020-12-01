package com.dxc.controller;

import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.User;
import com.dxc.service.Registrationservice;

@RestController
public class Registrationcontroller {

	@Autowired
	private Registrationservice service;
	
	//@RequestParam("id") int id, @RequestParam("fullName") String fullName, @RequestParam("userName") String userName, @RequestParam("emailId") String emailId, @RequestParam("mobile") String mobile, @RequestParam("password") String password)
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("users")
	public List<User> getUser()
	{
		return service.getUser();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("user")
	public User update(@RequestBody User user)
	{
		return service.update(user);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path = "User/{emailid}")
	public Optional<User> getUser(@PathVariable("emailid") String emailid) {
		Optional<User> user = service.findById(emailid);
		return user;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception
	{
		//String emailId = user.getEmailId();
		//user = new User(id, fullName, userName, emailId, mobile, password);
		String temail = user.getEmailId();
		String tpassword = user.getPassword();
		String strEncrypted = encrypt(tpassword);
		if(temail != null && !"".equals(temail))
		{
			User userobj = service.fetchUserByEmailId(temail);
			if(userobj != null)
			{
				throw new Exception("user with "+temail+" is already exist");
			}
		}
//		User userObj = null;
//		userObj = service.save(user);
//		return userObj;
		user.setPassword(strEncrypted);
		user=service.save(user);
		return user;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception 
	{
		String temail = user.getEmailId();
		String pass = user.getPassword();
		String strEncrypted = encrypt(pass);
		User userObj = null;
		if(temail !=null && pass != null)
		{
			userObj = service.fetchUserByEmailIdAndPassword(temail, strEncrypted);
		}
		if(userObj == null)
		{
			throw new Exception("Bad credentials");
		}
		return userObj;
	}
	
	private static String secretKey = "dxc";
	private static String salt = "dxc";
	 
	public static String encrypt(String strToEncrypt) 
	{
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
//	private static String secretKey = "dxc";
//	private static String salt = "dxc";
	 
	public static String decrypt(String strToDecrypt) {
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    } 
	    catch (Exception e) {
	        System.out.println("Error while decrypting: " + e.toString());
	    }
	    return null;
	}
	
}