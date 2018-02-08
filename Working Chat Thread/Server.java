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

		while(true){
		//Received the message
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String rcvdMsg = br.readLine();
		System.out.println("C: " + rcvdMsg); // Printed the rcvdMessage;

		OurMsg = sc.nextLine();  // Msg from our side..
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		out.println(OurMsg);
		out.flush();
		}
		
	} 
}