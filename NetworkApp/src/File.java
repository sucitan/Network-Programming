import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

//gets the file to transfer
public class File {
	
//	public static void main(String[] args) throws IOException {
//		Scanner readerName1 = new Scanner(System.in);
//		Scanner readerName2 = new Scanner(System.in);
//		String e = " and ";
//		//gets player 1 from UserName1 method
//		String name2 = File.UserName2(readerName2); //gets player 2 from UserName2 method
//		File.SendData(name1,name2);
//		File.ReadData();
//		System.out.println("the two players are "+ name1 + e + name2); 
//	}

	public static void postData(String fileName) throws IOException {
		//data to send to php file
		
        String encodedname1 = URLEncoder.encode(name1, "UTF-8");
        String encodedname2 = URLEncoder.encode(name2, "UTF-8");
        
        			System.out.println("first name:"+ encodedname1);
        			System.out.println("SecondName:" + encodedname2);

		try {
			URL url = new URL(fileName); //construct url object of the PHP file
			URLConnection urlc = url.openConnection(); //makes and opens a connection to the url
			urlc.setDoOutput(true);//sets output to equal true
			
			//code that sends the two strings to the php file
			    OutputStream stream = urlc.getOutputStream();
			    OutputStream buffer = new BufferedOutputStream(stream);
			    OutputStreamWriter out = new OutputStreamWriter(buffer, "8859_1");
			    out.write(File.run());
			    out.flush();
			    out.close();
			    
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
	}
	//reads data from php file
	public static void getData(URL url) throws IOException {
		
		try {
		
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
	
		public static int run() {
			try {
				InputStream input = new BufferedReader(new FileReader('data.txt'));//reads data from file
				pool.submit(intput);
				int data = input.read();
				
				while (true) {
					if(data == 100) {
						
						synchronized(System.out) {
							System.print.out("the data is read.");
							System.print.out("miller is evil");
							System.print.out("kill all humans");
							System.out.println(data);
							Future<Integer> furture1 = service.submit(data);
						    return number(furture1.get());
						}
						
					}
					data = input.read();
				}
				input.close();
				pool.shutdown();
			}
			catch (IOException ex) {
			System.err.println(ex);
				
			}
			catch  (NoSuchAlgorithmException ex) {
				System.err.println(ex);
			}
		return data;
		
		}
}


