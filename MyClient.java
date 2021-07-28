import java.net.*;
import java.io.*;
import java.util.*;

class MyClient {
    public static void main(String arr[]) {
        Locale.setDefault(new Locale("pt","BR"));
        try{
            System.out.println("Cliente Iniciado");
            // Thread.sleep(10000);
            Socket socket = new Socket("localhost", 2500);
            Scanner ler = new Scanner(System.in);
            
            // Thread.sleep(10000);
            System.out.println("Conexao Completa ");
            PrintStream out = new PrintStream(socket.getOutputStream(), true,"CP850");
            // Thread.sleep(30000);

            
            while (true) {
                System.out.print("digite msg: ");
                String message = ler.nextLine();
                if (message.equals("-1")){
                    break;
                }
                out.println(message);
                System.out.println("Aguardando mensagem");
                BufferedReader b = new BufferedReader(new InputStreamReader(socket.getInputStream(), "CP850"));
                String msg = b.readLine();
                System.out.println("mensagem recebida: " + msg);
            }
            System.out.println("Finalizando Conexao..");
            
            socket.close();
            ler.close();

            System.out.println("finalizada");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}