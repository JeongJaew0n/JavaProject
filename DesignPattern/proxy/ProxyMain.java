package proxy;

import proxy.aop.AopBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class ProxyMain {
    public static void main(String[] args) {
        Browser browser = new Browser("https://www.naver.com/");

        IBrowser bp = new BrowserProxy("where is here?");

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("kkk",
                () -> {
                        System.out.println("before");
                        start.set(System.currentTimeMillis());
                },
                () ->{
                        long now = System.currentTimeMillis();
                        end.set(now - start.get());
                }
        );

        aopBrowser.show();
        System.out.println("loading time: " + end.get());

        aopBrowser.show();
        System.out.println("loading time: " + end.get());
    }
}
