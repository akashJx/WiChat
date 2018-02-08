import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;

class Client{
	public static void main(String[] args)throws Exception  {
		String ip = "localhost";
		int port = 9999;
		Socket s = new Socket(ip,port);
		Scanner sc = new Scanner(System.in);
		String str;
		
		while(true){
		System.out.print("> ");
		str = sc.nextLine(); // Msg from our side.. 
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		out.println(str);
		os.flush();

		//Received the message
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String rcvdMsg = br.readLine();
		System.out.println("> : " + rcvdMsg); // Printed the rcvdMessage;
		}

		}
}