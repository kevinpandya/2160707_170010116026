import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException; 

public class Server
{ 
	public static void main(String[] args) throws IOException 
	{ 
		DatagramSocket ds = new DatagramSocket(1234); 
		byte[] receive = new byte[65535]; 
		DatagramPacket DpReceive = null;
		String rev = ""; 
		DpReceive = new DatagramPacket(receive, receive.length); 
		ds.receive(DpReceive); 
		StringBuilder str1 = new StringBuilder();
		str1 = data(receive);
		String str = str1.toString();
		for(int i=str.length()-1;i>=0;i--){
				rev = rev + str.charAt(i);
		}
		StringBuffer ans = new StringBuffer(rev);
		for (int i=0; i<rev.length(); i++)
        	{
            		Character c = rev.charAt(i);
            		if (Character.isLowerCase(c))
              			ans.replace(i, i+1, Character.toUpperCase(c)+"");
            		else
              			ans.replace(i, i+1, Character.toLowerCase(c)+"");
        	}
        	rev = ans.toString();
        	DatagramSocket ds1 = new DatagramSocket(); 
		InetAddress ip = InetAddress.getLocalHost(); 
		byte buf[] = null;
		buf = rev.getBytes();
		DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 2356); 
		ds1.send(DpSend); 
		receive = new byte[65535]; 
	}

	public static StringBuilder data(byte[] ans) 
    { 
        if (ans == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (ans[i] != 0) 
        { 
            ret.append((char) ans[i]); 
            i++; 
        } 
        return ret; 
    }
}