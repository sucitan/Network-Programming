import java.io.IOException;
import java.io.OutputStream;

public class PrintData {
    
private int amount[];
public PrintData (int amount[]) {
    this.amount = amount;
}

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
   		 return output;
   		 output.close();
   	 }
}
}
