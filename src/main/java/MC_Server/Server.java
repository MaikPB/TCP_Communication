package MC_Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int porta;

    public Server(int porta) {
        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Server in ascolto sulla porta " + porta);
        } catch (IOException e) {
            System.out.println("Errore apertura server");
            e.printStackTrace();
        }
    }

    public void attendi() {
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connesso\n" + "Scrivere 'exit' per chiudere le connessioni" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leggi() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String messaggio = in.readLine();
            System.out.println("CLIENT: " + messaggio);
            return messaggio;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String scrivi() {
        try {
            BufferedReader tastiera = new BufferedReader(
                    new InputStreamReader(System.in));

            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);

            System.out.print("SERVER: ");
            String messaggio = tastiera.readLine();

            out.println(messaggio);
            return messaggio;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void termina() {
        try {
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server chiuso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}