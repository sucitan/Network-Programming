import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

public class ConcreteCacheRequest extends CacheRequest {
//gives birth to the byte sender
	private ByteArrayOutputStream out = new ByteArrayOutputStream();

	@Override
	public void abort() {
		// TODO Auto-generated method stub
		out.reset();
	}

	@Override
	public OutputStream getBody() throws IOException {
		// TODO Auto-generated method stub
		return out;
	}

	 public byte[] getData() {
	    	if (out.size() == 0)
	            return null;
	        else
	            return out.toByteArray();
	
	 }	
}
