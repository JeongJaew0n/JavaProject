package adapter;

public class SocketAdapter implements Electronic110V{

    Electronic220V electronic220V;

    SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
