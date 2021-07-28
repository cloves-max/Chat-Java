import java.net.*;
import java.io.*;
import java.util.*;

class MyServer {
    public static void main(String arr[]) {
        System.out.println("Request received , connection completed...");
        try{
            ServerSocket server = new ServerSocket(2500);// the server is listening to at this port
            Scanner ler = new Scanner(System.in);
            System.out.println("Server is ready , waiting for a connection request...");

            /*
             * Now the accept() method blocks while it is waiting for a client Socket
             * connection.When a client finally tries to connect, the method returns a plain
             * old Socket (on a
             * 
             * diffrent port) that knows how to communicate with the client(i.e. knwos the
             * client IP address and port number).The SOcket is on a different port than the
             * ServerSocket,
             * 
             * so that the ServerSocket can go back to waiting for other clients.
             */

            Socket sock = server.accept();
            System.out.println("Conectando...");
            // Thread.sleep(10000);
            while (true){
                System.out.println("Contectado, Aguaardando mensagem...");
                BufferedReader b = new BufferedReader(new InputStreamReader(sock.getInputStream(), "CP850"));
                String msg = b.readLine();
                System.out.println("Received message " + msg);

                System.out.print("digite msg: ");
                String message = ler.nextLine();
                if (message.equals("-1")){
                    break;
                }
                PrintStream out = new PrintStream(sock.getOutputStream(), true,"CP850");
                // Thread.sleep(30000);
                out.println(message);
            }
            
            // Thread.sleep(10000);

            // System.out.println("Sending acknowledgement");
            // PrintStream out = new PrintStream(sock.getOutputStream());
            // // Thread.sleep(30000);
            // out.println("Hello client, your test message is received");
            System.out.println("Finalizando o Chat..");
            // Thread.sleep(50000);
            server.close();
            sock.close();
            ler.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}