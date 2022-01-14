package adapter;

public class AdapterMain {
    public static void main(String[] args) {
        AdapterMain Amain = new AdapterMain();

        HairDryer hairDryer = new HairDryer();
        Cleaner cleaner = new Cleaner();

        Amain.connect(hairDryer);
        Electronic110V clearAdapter = new SocketAdapter(cleaner);
        Amain.connect(clearAdapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        Amain.connect(airAdapter);
    }

    public void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
