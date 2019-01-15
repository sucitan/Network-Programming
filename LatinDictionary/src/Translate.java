
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;





public class Translate {

	private static String WordInEnglish;//class variable s
	private static char[] vowels = {'a','e','i','o','u'};
	
	
	public static void main (String[] args) {
		
	Translate t = new Translate();
	System.out.println("input word in english here");
	Scanner in = new Scanner(System.in);
	WordInEnglish = in.nextLine();
	
		for(int i =0;i<WordInEnglish.length();i++) {		
			if(WordInEnglish.charAt(i)==' ') {
				break;
			}
		}
		System.out.println(t.TransLatin(WordInEnglish));
		
	}
	
	
	
	public String TransLatin(String str) {
		
		String output = "could not connect to dictionary.org";
		try {
			InetAddress dict = new InetAddress("216.18.20.172");//i have no clue why this dont work even without parameters
			Socket socket = new Socket();
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			Writer writer = new OutputStreamWriter(out);
			Reader reader = new InputStreamReader(in);
			 writer.write("DEFINE fd-eng-lat " + str + "\r\n");
			 writer.flush();
			  int charInt;
			  String output="";
			 while((charInt = reader.read())!=-1) {
				 output = output + (char)charInt;
				 if(((char)charInt)==("]").charAt(0)) {
					 break;
				 }
			 }
			 return inputToLatin(output,str); 
		}
		catch(IOException ex) {
			System.out.println(ex);
			return output;
		}

		return str;

	}
	public static String inputToLatin(String input, String engWord) {
		
		if (input.contains("250") && !input.contains("552")) {
			input = input.substring(input.indexOf(engWord));
			input = input.substring(input.indexOf(engWord, input.indexOf(engWord) + 1));
			input = input.substring(0, input.indexOf("\n."));
			return input; } 
		else {
			return pigLatin(engWord) == "-1" ? "No Translation" : pigLatin(engWord);}
}
		
	}
	public static String pigLatin(String word) {
		int start = 0;
		int firstVowel = 0;
		int end = word.length();
		for(int i=0;i<end;i++) {
			char c = Character.toLowerCase(word.charAt(i));
			if(Arrays.asList(vowels).contains(c)) {
				firstVowel =i;break;
			}
			if(start!=firstVowel) {
				  String startString = word.substring(firstVowel, end);
			        String endString = word.substring(start, firstVowel) + "ay";
		return startString+endString; }	
			}return "-1";
		}
		
	}

