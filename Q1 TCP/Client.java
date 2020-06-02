import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class Client
{
	private static Socket socket;
	public static void main(String args[])
	{
		try
	    {
	    	String host = "localhost";
	      	int port = 25000;
		    InetAddress address = InetAddress.getByName(host);

		    socket = new Socket(address, port);

		    OutputStream out = socket.getOutputStream();
		      
	      	OutputStreamWriter osw = new OutputStreamWriter(out);

		    BufferedWriter buff = new BufferedWriter(osw);

	      	String str = "kevin pandya";
	      	String msg = str + "\n";
	      	buff.write(msg);
	      	buff.flush();
	      	System.out.println("Message sent to the server: " + msg.trim());

	      	InputStream is = socket.getInputStream();
	      	InputStreamReader isr = new InputStreamReader(is);
	      	BufferedReader br = new BufferedReader(isr);
	      	String message = br.readLine();

	      	System.out.println("Message received from the server : " + message);
	    }
	    catch (Exception e)
	    {
      		e.printStackTrace();
    	}
  	}
}