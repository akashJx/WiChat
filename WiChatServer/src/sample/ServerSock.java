package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSock extends Thread {
    ServerSocket ss;
    Socket s;

    @Override
    public void run() {
        // server is listening on port 5056
        //  ServerSocket ss = new ServerSocket(5056);
        try{
            ss = new ServerSocket(5056);
            System.out.println("SERVER STARTED..!!");
        }catch (Exception e){
            e.printStackTrace();
        }

        // running infinite loop for getting
        // client request
        while (true)
        {
            s = null;
            try
            {
                // socket object to receive incoming client requests
                s = ss.accept();
                System.out.println("A new client is connected : " + s);

                // obtaining input and out streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Assigning new thread for this client");

                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos);

                // Invoking the start() method
                t.start();
            }
            catch (Exception e){
                // Forcefully
                try {
                    s.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }
}
