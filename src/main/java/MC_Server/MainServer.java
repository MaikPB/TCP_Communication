package MC_Server;

public class MainServer {
    public static void main(String[] args) {

        Server server = new Server(3000);

        server.attendi();

        while (i != "esci") {

            server.leggi();
            server.scrivi();

        }

        server.termina();

    }
}