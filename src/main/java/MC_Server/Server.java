package MC_Server;

import java.io.IOException;
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
            System.err.println("...");
        }
    }


    public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Il client ha accettato la richiesta");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        finally{
            return clientSocket;
        }
    }


    public void chiudi(){

        try {
            clientSocket.close();
        } catch (IOException e) {
            //
        }
    }


    public void termina(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            //
        }
    }

}
