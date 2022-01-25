package decorator;

public class AudiDecorator implements ICar{

    protected ICar audi;
    protected String modelName;
    protected int modelPrice;
    protected String color;

    public AudiDecorator(ICar audi, String modelName, int modelPrice, String color){
        this.audi = audi;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getPrice() {
        return audi.getPrice() + this.modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(String.format("%s 모델의 가격은: %d, 색깔은: %s",modelName,getPrice(),color));
    }
}
