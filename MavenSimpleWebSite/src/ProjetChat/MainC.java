class MainC {
    public static void main(String[] args) {
        User marco = new User(4);
        marco.modifyPseudo("Marco");
        UserSocketUDP marcSocketUDP = new UserSocketUDP(marco);
        try {
            marcSocketUDP.receiveMessage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}