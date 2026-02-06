package MC_Client;

import MC_Server.Server;

public class MainClient {
    public static void main(String[] args) {

        Client client = new Client("Maikol");
        client.connetti("localhost", 3000);
    }
}