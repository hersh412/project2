package com.revature.utils;



import java.util.logging.Level;
import java.util.logging.Logger;

public class TokenFactoryUtil {
	
	private static final long SECRETNUMBER = 278493;
	private static long Time;
	private static long nextL;
	private static int nextCharInt;
	private static String nextChar;
	private static String key;
	private static Logger log = Logger.getLogger("TokenFactoryUtil");
	
	public static String getToken(long userId) {
		Time = Math.abs(System.nanoTime());
		nextL=Time;
		while (nextL>100) {
			log.log(Level.INFO, "nextL"+nextL);
			nextCharInt = (int) (nextL%89 +32);
			nextChar = Character.toString((char) nextCharInt);
			nextL /= 100;
			key += nextChar;
		}
		nextL = Time* userId;
		while (nextL>100) {
			nextCharInt = (int) (nextL%89 +32);
			nextChar = Character.toString((char) nextCharInt);
			nextL /= 100;
			key += nextChar;
		}
		nextL = Time*SECRETNUMBER;
		while (nextL>100) {
			nextCharInt = (int) (nextL%89 +32);
			nextChar = Character.toString((char) nextCharInt);
			nextL /= 100;
			key += nextChar;
		}
		log.log(Level.INFO, "token: "+key);
		return key;
		
	}
	
	private TokenFactoryUtil() {
		
	}
}
 