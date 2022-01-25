package decorator;

public class Audi implements ICar{

    private int carPrice;
    private String color;

    public Audi(int carPrice) {
        this.carPrice = carPrice;
        this.color = "basic";
    }

    /* 밑의 구현은 패턴 공부할 때는 구현 안해도됨. */
    /* 단순 훅 메소드가 되어도 됨 */

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getPrice() {
        return carPrice;
    }

    @Override
    public void showPrice() {
        System.out.println("이 차의 비용은: "+carPrice + "색은: " + color);
    }
}
