import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	 
			public final static int PORT = 13;
			public final static Logger LOG = new Logger();
		    
		    public static void main(String[] args) {
		    	try (ServerSocket serverSock = new ServerSocket(PORT)) {
		            while (true) {
		            	try (Socket connection = serverSock.accept()) {
		            		request(serverSock.getInetAddress().toString());
		                    Writer out = new OutputStreamWriter(connection.getOutputStream());
		                    Date now = new Date();
		                    out.write(now.toString() + "\r\n");
		                    out.write(Logger.getHistory());
		                    out.flush();
		                    connection.close();
		                } catch (IOException ex) { System.err.println(ex); error(serverSock.getInetAddress().toString(), ex.toString()); }
		            }
		        } catch (IOException ex) { System.err.println(ex); }
		    }
		    
		    private static void error(String client, String error) {
		    	Logger.error(client, error);
		    }
		    
		    private static void request(String client) {
		    	Logger.request(client);
		}
	
	
}