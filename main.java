import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class main {
 public static void streamNumbers(OutputStream out) throws IOException{
	   	 
	   	 int firstNum =  1;
	   	 int amountNum = 100;
	   	 byte[] output = new byte[amountNum] ;
	   	 
	   	 while (true) {
	    
	   		 for (int i = firstNum;i<=amountNum;i++) {
	   			 out.write(output); 
	   		 }
	   		 output[10] = '\r';
	   		 output[11] = '\n';
	   	 output.flush();
	   	 
	   	 }
	   	 try {
	   		 output = new BufferedWriter(new FileWriter('data.txt'));
	   	 }
	   	 finally {
	   		 output.close();
	   	 }
	    }
	    public static void InputStream (InputStream out )throws IOException{
	   	 
	   	 InputStream input = new BufferedReader(new FileReader('data.txt'));
	   	 
	   	 int data = input.read();
	   	 
	   	 while (true) {
	   		 if(data == 100) {
	   			 system.print.out("the data is read.")
	   		 }
	   		 data = input.read();
	   	 }
	   	 input.close();
	    }
	    
	   	 
}
