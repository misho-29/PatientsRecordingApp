package Server;

public class Server {
    public static void main(String[] args) {
        System.out.println("Hello Server!!!!");
        SocketServer s = new SocketServer();
        s.runServer();
    }
}
