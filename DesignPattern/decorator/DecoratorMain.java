package decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        ICar audi = new Audi(10000);
        audi.showPrice();

        ICar a3 = new A3(audi, "A3");
        a3.showPrice();
        ICar a4 = new A4(audi, "A4");
        a4.showPrice();
    }
}
