package decorator;

public class Audi implements ICar{

    private int carPrice;

    public Audi(int carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public int getPrice() {
        return carPrice;
    }

    @Override
    public void showPrice() {
        System.out.println("이 차의 비용은: "+carPrice);
    }
}
