package observer;

public class ObserverMain {

    public static void main(String[] args){
        Button button = new Button("버튼");

        button.addListener({
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
    }
}
