package MC_Server;

public class MainServer {

    public static void main(String[] args) {

        Server server = new Server(3000);
        server.attendi();

        String messaggio = "";

        while (!messaggio.equals("exit")) {

            messaggio = server.leggi();

            if (!messaggio.equals("exit")) {
                messaggio = server.scrivi();
            }
        }

        server.termina();
    }
}