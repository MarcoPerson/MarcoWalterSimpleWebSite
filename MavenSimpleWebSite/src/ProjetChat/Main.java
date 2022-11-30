import java.net.SocketException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws SocketException {
        User walter = new User(1);

        // Scanner scanf = new Scanner(System.in);
        // String pseudo = scanf.nextLine();
        // scanf.close();
        walter.modifyPseudo("Walter");
        
        UserSocketUDP walSocketUDP = new UserSocketUDP(walter);
        walter.connectToNetwork(walSocketUDP);
        try {
            walSocketUDP.waitForAggrement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}