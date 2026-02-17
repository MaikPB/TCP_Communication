package MC_Client;

import java.io.*;
import java.net.Socket;

public class Client {

    private String nome;
    private String colore;
    private Socket socket;   // UNICA socket

    // Costruttore base
    public Client(String nome) {
        this.nome = nome;
    }

    // Costruttore con colore
    public Client(String nome, String colore) {
        this.nome = nome;
        this.colore = colore;
    }

    // Connessione al server
    public int connetti(String nomeServer, int portaServer) {
        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println("Client " + nome + ": connessione effettuata");
            return 1;
        } catch (IOException e) {
            System.out.println("Client " + nome + ": connessione non effettuata");
            e.printStackTrace();
            return 0;
        }
    }

    // Scrive un messaggio al server
    public void scrivi() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);


            printWriter.println("Ciao dal client " + nome);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Legge un messaggio dal server
    public void leggi() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String testo = br.readLine();
            System.out.println("SERVER: " + testo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Chiude la connessione
    public void chiudi() {
        try {
            socket.close();
            System.out.println("Connessione Client chiusa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
