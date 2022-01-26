package observer;

public class ObserverMain {

    public static void main(String[] args){
        /* 버튼 하나 생성 */
        Button button = new Button("버튼");
        
        /* 버튼의 이벤트를 받아줄 Listener 생성 */
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {      // 버튼을 클릭하면 이벤트 리스너가 그걸 받고 알려준 다음
                                                        // 이벤트를 처리한다.
                System.out.println(event);
            }
        });

        button.click("메세지 전달: click1");
        button.click("메세지 전달: click2");
        button.click("메세지 전달: click3");
        button.click("메세지 전달: click4");

    }
}
