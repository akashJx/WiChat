import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.Socket;

class NewClient{
	public static void main(String[] args)throws Exception  {
		String ip = "localhost";
		int port = 9999;
		Socket s = new Socket(ip,port);
			
		MsgHandler msgHandlerob = new MsgHandler(ip,port,s);
		Thread t1 = new Thread(msgHandlerob);
		Scanner sc = new Scanner(System.in);
		t1.start();
		String str;

		while(true){
		System.out.print("> ");
		str = sc.nextLine(); // Msg from our side.. 
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		out.println(str);
		os.flush();

		/*//Received the message
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String rcvdMsg = br.readLine();
		System.out.println("> : " + rcvdMsg); */// Printed the rcvdMessage;
		}

		} // END OF MAIN
}

class MsgHandler extends Thread{
	String ip;
	int port;
	Socket s;

	MsgHandler(String ip,int port,Socket s){
		this.ip = ip;
		this.port = port;
		this.s = s;
	}

	@Override
	public void run(){
		BufferedReader br;
		//Received the message
		try{
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String rcvdMsg = br.readLine();
			System.out.println("> : " + rcvdMsg);
		}catch(Exception e){

		} 
	}
}