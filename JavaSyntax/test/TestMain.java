package test;

public class TestMain {
    int a = 5;
    int te = 123;
    public static void main(String[] args) {
        int k = 99;
        TestMain tm = new TestMain();
        tm.callByValue(k,tm.te);
        System.out.println(k + " " + tm.te);
        tm.callByReference(tm);
        System.out.println(tm.a + " " + tm.te);

    }

    void callByValue(int x, int y) {
            x = 3;
            y = 3;
    }

    void callByReference(TestMain tm){
        tm.a = 10;
    }

}
