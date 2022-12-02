import java.net.DatagramPacket;

class MainV {
    public static void main(String[] args) {
        User marco = new User(2);
        marco.modifyPseudo("Brandon");
        UserSocketUDP marcSocketUDP = new UserSocketUDP(marco);
        Thread reception = new Thread(() -> marcSocketUDP.receiveMessage());
        reception.start();
    }
}