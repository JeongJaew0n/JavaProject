package observer;

public interface IButtonListener {
    void clickEvent(String event);
}

// 여기는 만약 서버나 그런 곳에서 버튼의 상태를 받아와서 이벤트를 처리해줄건데,
// 버튼을 사용하는 입장에서는 내부구조는 알 필요가 없고,
// 그저 clickEvent 를 반환해주면 그걸 쓰면된다.