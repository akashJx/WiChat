import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;
import java.net.ServerSocket;

class Server {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String OurMsg;
		System.out.println("S: Server is started..");

		ServerSocket ss = new ServerSocket(9999);
		System.out.println("Server is waiting for request..");
		Socket s = ss.accept();
		System.out.println("Client Connected..\n\n");

	/*	while(true){
		//Received the message
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String rcvdMsg = br.readLine();
		System.out.println("C: " + rcvdMsg); // Printed the rcvdMessage;

		OurMsg = sc.nextLine();  // Msg from our side..
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		out.println(OurMsg);
		out.flush();    */
		}
		
	} 
}

public class MsgHandler extends Thread{

	String ip;
	int port;
	Socket s;
	BufferedReader br;
	String rcvdMsg;

	MsgHandler(String ip,int port,Socket s){
		this.ip = ip;
		this.port = port;
		this.s = s;
	}

	@Override
	public void run(){
	

	br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	rcvdMsg	= br.readLine();
	System.out.println("C: " + rcvdMsg); // Printed the rcvdMessage;
	}
}