import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ViewWebPage {
//so basically this will fetch data from a url in the interwebs
	public static void main(String[] args) throws IOException {
		
		if(args.length>0) {
			try {
				URL url = new URL("yhscs.us");
				URLConnection urlc = url.openConnection();
				try (InputStream input = urlc.getInputStream()) {
				InputStream buffer = new BufferedInputStream(input);
					Reader reader = new InputStreamReader(buffer);
					int c;
					while ((c = reader.read()) != -1) {
						System.out.print((char)c);
					}
				}
				catch(IOException ex) {
					System.out.println("threw a heckin exceoption");
				}
				
				}
			catch (MalformedURLException ex) {
			System.out.println("threw a url exception");
				}
		}

	}

}
