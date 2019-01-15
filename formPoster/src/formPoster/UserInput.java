package formPoster;
import java.io.*;
import java.net.*;
import java.util.*;
public class UserInput {
	
	
	//
	//		just serving up some actual good looking code
	//
										
	//		constructor which I didn't use    
	//		public UserInput (Scanner readerName1,Scanner readerName2) {
	//		this.readerName1 = readerName1;
	//		this.readerName2 = readerName2;		
	//			}
	
	
	//main method
	public static void main(String[] args) throws IOException {
		Scanner readerName1 = new Scanner(System.in);
		Scanner readerName2 = new Scanner(System.in);
		String e = " and ";
		String name1 = UserInput.UserName1(readerName1);//gets player 1 from UserName1 method
		String name2 = UserInput.UserName2(readerName2); //gets player 2 from UserName2 method
		UserInput.SendData(name1,name2);
		UserInput.ReadData();
		System.out.println("the two players are "+ name1 + e + name2); 
	}

	public static void SendData(String name1, String name2) throws IOException {
		//strings to send to php file
		
        String encodedname1 = URLEncoder.encode(name1, "UTF-8");
        String encodedname2 = URLEncoder.encode(name2, "UTF-8");
        
        			System.out.println("first name:"+ encodedname1);
        			System.out.println("SecondName:" + encodedname2);

		try {
			URL url = new URL(""); //construct url object of the PHP file
			URLConnection urlc = url.openConnection(); //makes and opens a connection to the url
			urlc.setDoOutput(true);//sets output to equal true
			
			//code that sends the two strings to the php file
			    OutputStream stream = urlc.getOutputStream();
			    OutputStream buffer = new BufferedOutputStream(stream);
			    OutputStreamWriter out = new OutputStreamWriter(buffer, "8859_1");
			    out.write(name1 + name2);
			    out.flush();
			    out.close();
			    
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
	}
	//reads data from php file
	public static void ReadData() throws IOException {
		
		try {
		URL url = new URL("");
		URLConnection urlc = url.openConnection();
		try (InputStream input = urlc.getInputStream()) {
			
			InputStream buffer = new BufferedInputStream(input);
			Reader reader = new InputStreamReader(buffer);
			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char)c);
			}
		}
		}
		catch (MalformedURLException ex) {
			System.err.println(ex);
		}
		catch(IOException ex) {
			System.err.println(ex);
		}
		
		
	}
	
	//gets name 1 with scanner obj
	public static String UserName1(Scanner readerName1) {	
		System.out.println("Player1 is:");
		String name1 = readerName1.nextLine();
		return name1;
	}
	//gets name 2 with scanner obj
	public static String UserName2(Scanner readerName2) {	
		System.out.println("player2 is:");
		String name2 =readerName2.nextLine();
		return name2;
	}
	
}
