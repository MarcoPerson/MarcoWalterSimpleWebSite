import java.net.SocketException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws SocketException {
        User walter = new User(1);
        Scanner pseudoChooser = new Scanner(System.in);
        UserSocketUDP walSocketUDP = new UserSocketUDP(walter);
        boolean agreed = false;
        do {
            System.out.print("Choose a new Pseudo : ");
            walter.modifyPseudo(pseudoChooser.nextLine());
            walter.connectToNetwork(walSocketUDP);
            agreed = walSocketUDP.waitForAggrement();
        } while (agreed == false);

        walSocketUDP.broadcast(walter.getId(), walter.getPseudo(), "newUser");
        Thread reception = new Thread(() -> walSocketUDP.receiveMessage());
        reception.start();

        pseudoChooser.close();
    }
}