import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TetrisIsHard {
		Exception BadNumberException = new Exception();
	public static void main (String[] args) {
		if (args.length > 0) {
			try {
				URL url = new URL(args[0]);
				//this makes the headers
				URLConnection urlC = url.openConnection();String header2 = urlC.getHeaderFieldKey(2);String server = urlC.getHeaderField("server");String header1 = urlC.getHeaderField(2);
				
				System.out.println(header2 + server + header1); //print the headers out
				
				//read from file
				try (InputStream input = urlC.getInputStream()) {
					InputStream buffer = new BufferedInputStream(input);
					Reader reader = new InputStreamReader(buffer);
				
					System.out.println(header2 + server + header1);
					
					int c;
					while ((c = reader.read()) != -1) {
						System.out.print((char)c);
					}
				}
			}
			catch (MalformedURLException ex) {
				System.err.println(" Heckin No work DUDE");
			}
			catch (IOException ex) {
				System.err.println(ex + " What the HECKIN ININ HECKE DUDE");
			}
			
		}
	}
//this also reads data from a url but better
	public URLConnection checkHeader(URLConnection urlC)) throws IOException  {
		
		String BodyResponse =urlC.getContentType() ;
		//One huge if statement cause why not
		if(BodyResponse != null && urlC.getContentEncoding() == null && urlC.getAllowUserInteraction()==true && urlC.getDoInput()==true 
			for(int i =0;i<urlC.getContentLength();i++) {
				try (InputStream input = urlC.getInputStream())= {
					//what
					URLConnection urlThing = urlC.openConnection();
					InputStream buffer = new BufferedInputStream(input);
					Reader reader = new InputStreamReader(buffer);
					out.write("fileOfPhp");
					out.flush();
					out.close();
					int c;
					while ((c = reader.read()) != -1) {
						System.out.print((char)c);
					}
					System.out.println(urlC.getDate());			
					System.out.println(urlC.getExpiration());
					System.out.println(urlC.getLastModified());
				}
				catch(IOException ex) {
					System.out.println(ex);
				}
		}	
			
				
			
		}	
		return urlC;
	}
}

