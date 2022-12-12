import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class clientTCP {
    public static void main(String[] args) throws UnknownHostException {
        OnlineUser walter = new OnlineUser("walter", 1, InetAddress.getLocalHost(), 1234);
        OnlineUser walt = new OnlineUser("walt", 237, InetAddress.getLocalHost(), 1234);
        UserSocketClient walterSocket = new UserSocketClient(walter);
        UserSocketClient waltSocket = new UserSocketClient(walt);
        try {
            walterSocket.connectTo(walter);
            waltSocket.connectTo(walter);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
