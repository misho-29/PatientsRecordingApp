package Server;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server Started");
        SocketServer s = new SocketServer();
        s.runServer();
    }
}
