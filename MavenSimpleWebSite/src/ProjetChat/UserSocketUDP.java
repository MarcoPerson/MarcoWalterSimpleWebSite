import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;

class UserSocketUDP {
    private User user;
    private DatagramSocket socketUDP;

    public UserSocketUDP(User _user) {
        user = _user;
        try {
            socketUDP = new DatagramSocket(2504);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void broadcast(int _id, String _pseudo, String _message) throws IOException {
        int port = 2504;
        byte[] message = new byte[50];
        message = String.valueOf(_id).concat("::").concat(_pseudo).concat("::").concat(_message).getBytes();
        Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
        NetworkInterface ni = en.nextElement();
        InterfaceAddress ia = ni.getInterfaceAddresses().get(1);
        InetAddress ipAddress = ia.getBroadcast();
        DatagramPacket packet = new DatagramPacket(message, message.length, ipAddress, port);
        socketUDP.send(packet);
        System.out.println(" Broadcast = " + ipAddress.getHostAddress());
    }

    public void sendMessage(OnlineUser _user, int _id, String _pseudo, String _message) throws IOException {
        int port = 2504;
        byte[] message = new byte[50];
        message = String.valueOf(_id).concat("::").concat(_pseudo).concat("::").concat(_message).getBytes();
        InetAddress ipAddress = _user.getIpAddress();
        DatagramPacket packet = new DatagramPacket(message, message.length, ipAddress, port);
        socketUDP.send(packet);
    }

    public boolean waitForAggrement() throws IOException {
        boolean agreed = true;
        long time = System.currentTimeMillis();
        // socketUDP.setSoTimeout(2000);
        byte[] message = new byte[50];
        DatagramPacket packet = new DatagramPacket(message, message.length);
        while (System.currentTimeMillis() - time < 5000 && agreed) {
            socketUDP.receive(packet);
            String[] data = packet.getData().toString().split("::");
            if (data[3].compareTo("ok") == 0)
                agreed = false;
            user.getUserBookManager().addOnlineUser(Integer.parseInt(data[0]),
                    new OnlineUser(data[1], Integer.parseInt(data[0]), packet.getAddress(), packet.getPort()));
        }
        if (!agreed) {
            user.getUserBookManager().deleteAllOnlineUser();
        }
        return agreed;
    }

    public DatagramPacket receiveMessage() throws IOException {
        boolean agreed = true;
        byte[] message = new byte[50];
        DatagramPacket packet = new DatagramPacket(message, message.length);
        while (agreed) {
            System.out.println("En attente de la reception des ...");
            socketUDP.receive(packet);
            String[] data = packet.getData().toString().split("::");
            System.out.println("Message reçu = " + Arrays.toString(data));
            agreed = false;
        }
        return packet;
    }

}
