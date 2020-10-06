package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 * 
	 
	 */
	
	
	public static void main (String[] args) {
		String inp = "";
		String output = "";
	try {
	FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/result.txt");
	BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/result.txt"));
	String line = br.readLine();
	while (line != null) {
		inp+=line;
		line = br.readLine();
	}
	
	}
	catch (Exception e){
		e.printStackTrace();
	}
	System.out.println(inp);
	String key = "abcdefghijklmnopqrstuvwxyz";
	String encryptKey = "efghijklmnopqrstuvwxyzabcd";
	
	for (int i = 0; i < inp.length(); i++) {
		System.out.println(inp.charAt(i));
		output+=key.charAt(encryptKey.indexOf(inp.charAt(i)));
	}
	JOptionPane.showMessageDialog(null, output);
	}
	
	
	
	
	
}
