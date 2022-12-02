import java.net.DatagramPacket;

class MainS {
    public static void main(String[] args) {
        User marco = new User(3);
        marco.modifyPseudo("Walter");
        UserSocketUDP marcSocketUDP = new UserSocketUDP(marco);
        Thread reception = new Thread(() -> marcSocketUDP.receiveMessage());
        reception.start();
    }
}