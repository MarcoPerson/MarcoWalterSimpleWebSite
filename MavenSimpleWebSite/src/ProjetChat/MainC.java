import java.net.DatagramPacket;

class MainC {
    public static void main(String[] args) {
        User marco = new User(4);
        marco.modifyPseudo("Marco");
        UserSocketUDP marcSocketUDP = new UserSocketUDP(marco);
        Thread reception = new Thread(() -> marcSocketUDP.receiveMessage());
        reception.start();
    }
}