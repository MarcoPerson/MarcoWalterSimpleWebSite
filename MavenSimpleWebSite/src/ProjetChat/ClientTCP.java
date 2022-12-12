import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class ClientTCP {
    public static void main(String[] args) throws UnknownHostException {
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            NetworkInterface ni = en.nextElement();
            InterfaceAddress ia = ni.getInterfaceAddresses().get(1);
            InetAddress ipAddress = ia.getAddress();
            System.out.println("My Address : " + ipAddress.getHostAddress());
            OnlineUser walter = new OnlineUser("walter", 237, InetAddress.getByName("10.1.5.232"), 1234);
            UserSocketClient marcoSocket = new UserSocketClient();
            marcoSocket.initChat(walter);
        } catch (Exception e) {
        }
    }
}
