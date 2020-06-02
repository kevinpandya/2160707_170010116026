import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
public class Server
{  
	private static Socket socket;
	public static void main(String[] args)
  	{
    	try
    	{
      		int port = 25000;
      		ServerSocket serverSocket = new ServerSocket(port);
		    System.out.println("Server Started on port 25000");

		    socket = serverSocket.accept();
		    InputStream is = socket.getInputStream();
		    InputStreamReader isr = new InputStreamReader(is);
		    BufferedReader br = new BufferedReader(isr);
        	String input = br.readLine();
        	System.out.println("Message received from client is " + input);
       	 	String message;

        	StringBuilder input1 = new StringBuilder();
        	input1.append(input);

        	input1 = input1.reverse();
        	String out = input1.toString();

        	StringBuffer capital =  new StringBuffer(out);
        	int ln = capital.length();

        	for (int i=0; i<ln; i++)
         	{
            	Character ch = capital.charAt(i);
            	if (Character.isLowerCase(ch))
              		capital.replace(i, i+1, Character.toUpperCase(ch)+"");
            	else
              		capital.replace(i, i+1, Character.toLowerCase(ch)+"");
         	}

         	message = capital.toString();

        	OutputStream os = socket.getOutputStream();

        	OutputStreamWriter osw = new OutputStreamWriter(os);

        	BufferedWriter bw = new BufferedWriter(osw);
        	bw.write(message);

        	System.out.println("Message sent to the client is "+message);
        	bw.flush();
    	}
    	catch (Exception e)
    	{
      		e.printStackTrace();
    	}
  	}
}