import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import sun.misc.BASE64Encoder;
public class Base64Util 
{
	public static void main(String args[]) throws IOException
	{
		System.out.print("�������û���:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String userName = in.readLine();
		System.out.print("����������:");
		String password = in.readLine();
		BASE64Encoder encoder = new BASE64Encoder();
		System.out.println("�������û���Ϊ:" 
				+ encoder.encode(userName.getBytes()));
		System.out.println("����������Ϊ:" 
				+ encoder.encode(password.getBytes()));		
	}
}