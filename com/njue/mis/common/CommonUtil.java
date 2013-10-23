package com.njue.mis.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtil {
	public static String md5s(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			String result = buf.toString();
			return result;
		} catch (NoSuchAlgorithmException e) {
		  	// TODO Auto-generated catch block
		  	e.printStackTrace();
		  	return null;
		}
	}
	public static void main(String[] args){
		CommonUtil util = new CommonUtil();
		System.out.println(util.md5s("ÉÌÆ·A"));
	}
}
