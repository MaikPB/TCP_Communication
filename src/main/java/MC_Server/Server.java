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
            System.out.println("Il server è in ascolto");
        }
        //catch{

        //}
        catch (IOException e) {
            System.err.println("Il server non resce ad aprire la porta ed a completare la fase d'ascolto");
        }
    }


    public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Il client ha accettato la richiesta");
            System.out.println("Per uscire scrivere 'esci'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally{
            return clientSocket;
        }
    }


    public void scrivi() {
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);

            printWriter.println("Ciao");

            printWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void leggi(){


        try {

            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String testo = br.readLine();
            System.out.println("CLIENT: " + testo);

        } catch (IOException e) {
            throw  new RuntimeException(e);
        }

    }


    public void termina(){
        try {
            System.out.println("Connessione Server chiusa");
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
