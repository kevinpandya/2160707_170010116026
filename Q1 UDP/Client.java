import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 

class Client 
{ 
	public static void main(String args[]) throws IOException 
	{ 
		DatagramSocket ds = new DatagramSocket(); 
		InetAddress ip = InetAddress.getLocalHost(); 
		byte buff[] = null;
		Scanner sc = new Scanner(System.in);  
		String str = sc.nextLine();  
		buff = str.getBytes(); 
		DatagramPacket DpSend = new DatagramPacket(buff, buff.length, ip, 1234); 
		ds.send(DpSend);
		DatagramSocket dsoc = new DatagramSocket(2356); 
		byte[] receive = new byte[65535]; 
		DatagramPacket dpr = new DatagramPacket(receive, receive.length); 
		dsoc.receive(dpr); 
		System.out.println("Server :-" + data(receive)); 
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

