package MC_Server;

public class MainServer {
    public static void main(String[] args) {

        Server server = new Server(3000);

        server.attendi();
        server.leggi();
        server.scrivi();
        server.termina();

    }
}