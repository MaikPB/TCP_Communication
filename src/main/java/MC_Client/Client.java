package MC_Client;

import java.io.*;
import java.net.Socket;

public class Client {

    private String nome;
    private Socket socket;

    public Client(String nome) {
        this.nome = nome;
    }

    public int connetti(String server, int porta) {
        try {
            socket = new Socket(server, porta);
            System.out.println("Client connesso al server\n" + "Scrivere 'exit' per chiudere le connessioni");
            return 1;
        } catch (IOException e) {
            System.out.println("Errore connessione");
            e.printStackTrace();
            return 0;
        }
    }

    public String scrivi() {
        try {
            BufferedReader tastiera = new BufferedReader(
                    new InputStreamReader(System.in));

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            System.out.print("CLIENT: ");
            String messaggio = tastiera.readLine();

            out.println(messaggio);
            return messaggio;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String leggi() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String messaggio = in.readLine();
            System.out.println("SERVER: " + messaggio);
            return messaggio;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void chiudi() {
        try {
            socket.close();
            System.out.println("Client chiuso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}