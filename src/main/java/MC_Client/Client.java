package MC_Client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private String nome;
    private String colore;
    private Socket socket;


    public Client(String nome) {
        this.nome = nome;
    }


    public Client(String nome, String colore) {
        this.nome = nome;
        this.colore = colore;
    }


    public int connetti(String nomeServer, int portaServer) {
        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println("Client " + nome + ": connessione effettuata");

            return 1;
        } catch (IOException e) {
            //
        }
        return 1;
    }

    public void scrivi(){

        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);

            printWriter.print("Ciao");

            printWriter.flush();

            //CHIUDERE LO STREAM

        } catch (IOException e) {
            //
        }

    }

    public void leggi(){}

    public void chiudi(){}
}
