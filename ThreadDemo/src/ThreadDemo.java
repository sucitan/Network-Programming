import java.io.*;
import java.security.*;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo implements Runnable{

private String filename;

public ThreadDemo(String filename) {
    this.filename = filename;
}

@Override
public void run() {

try {
    InputStream input = new BufferedReader(new FileReader('data.txt'));//reads data from file
    pool.submit(input);
    int data = input.read();
    
    while (true) {
   	 if(data == 100) {
   		 
   		 synchronized(System.out) {
   			 System.print.out("the data is read.");
   			 System.print.out("miller is evil");
   			 System.print.out("kill all humans");
   			 System.out.println(data);
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
public static int number(int[]amount) throws InterruptedException, ExecutionException {
    if(amount.length == 1)
   	 return amount[0];
    else if (amount.length ==0) {
   	 throw new IllegalArgumentException();
    }
    PrintData data1 = new PrintData(amount);
    ExecutorService service = Executors.newFixedThreadPool(2);
    
    Future<Integer> furture1 = service.submit(data1);//dont know why this doesent work
    return number(furture1.get());
}

public static void main (String[] args) {
    for (String filename : args) {
   	 ThreadDemo demo = new ThreadDemo(filename);
   	 Thread t= new Thread(demo);
   	 t.start();
    }
}

}
