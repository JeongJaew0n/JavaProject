package singleton;

public class SingletonMain {
//
    public static void main(String[] args) {
	// write your code here
        Aclazz aclazz = new Aclazz();
        Bclazz bclazz = new Bclazz();

        SocketClient aClient = aclazz.getSocketClient();
        SocketClient bClient = bclazz.getSocketClient();

        System.out.println("두 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
    }
}
