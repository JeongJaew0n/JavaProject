package observer;

/* 옵저버 패턴은 객체의 상태 변화를 관찰하는 관찰자들,
 즉 옵저버들의 목록을 객체에 등록하여 상태 변화가 있을 대 마다 메서드 등을 통해 객체가
 직접 목록의 각 옵저버에게 통지하도록 하는 디자인 패턴이다.

*  */

public class Button {
    private String name;
    private IButtonListener buttonListener;     // 옵저버, 버튼의 상태변화를 받아서 알려준다.
    // 버튼의 클릭시 해당 이벤트를 받아주는 Listener 가 있다.

    public Button(String name) {        // 버튼은 이름이 있고
        this.name = name;
    }

    public void click(String message) {
        buttonListener.clickEvent(message);
    }

    public void addListener(IButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }
}
