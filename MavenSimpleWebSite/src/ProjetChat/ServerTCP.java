import java.net.UnknownHostException;

public class ServerTCP {
    public static void main(String[] args) throws UnknownHostException {
        UserSocketServer walterSocketServer = new UserSocketServer();
        walterSocketServer.listen();
    }
}
