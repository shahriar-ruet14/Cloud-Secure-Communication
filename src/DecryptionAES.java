

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class DecryptionAES {
	
	
	static Cipher cipher;
	
	public static void AESdecryption(String cipherText) throws Exception{
	print("\nAES Decryption Initializing");
	
	SecretKey secretKey = KeyStatic.key(); // Get existing Key
	cipher = Cipher.getInstance("AES");
	
	
	long tic = System.nanoTime(); //Time Stamp
	String decryptedText = decrypt(cipherText, secretKey);
	long toc = System.nanoTime(); //final time
	long elapsedTime = toc - tic;
	System.out.println("\nDecryptionAES: Elapsed Time : "+ elapsedTime+" ns \n \t  \t OR " 
	+ elapsedTime/1000000000+" Seconds");
	
	
	print("\nClient1> message>DecriptionAES >> : Decrypted Final Text:\n\n\t\t" + decryptedText);
	print("\n\n\n\n");
		
	}
	
	
	
	public static String decrypt(String encryptedText, SecretKey secretKey)
			throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
	}
	
	public static void print(Object e)
	{
		System.out.println(e);
	}
}
