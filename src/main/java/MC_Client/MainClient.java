package MC_Client;

public class MainClient {

    public static void main(String[] args) {

        Client client = new Client("Maikol");

        if (client.connetti("localhost", 3000) == 1) {

            String messaggio = "";

            while (!messaggio.equals("exit")) {

                messaggio = client.scrivi();

                if (!messaggio.equals("exit")) {
                    client.leggi();
                }
            }

            client.chiudi();
        }
    }
}