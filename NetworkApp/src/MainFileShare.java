import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//shares files because everyone needs a file		
public class MainFileShare {

	public static void main (String[] args) throws IOException {
		URL url = new URL("yhscs.us");
		String name = "yhscs.us";
		
		File toSend = new File();
		toSend.getData(url);
		toSend.postData(name);
		
		

	}
}
