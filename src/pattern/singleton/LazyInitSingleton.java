package pattern.singleton;

/**
 * Lazy Initialization with synchronized (동기화 블럭, Thread-safe)
 *
 * 두 번째 방식은, synchronized 키워드를 이용한 게으른 초기화 방식인데,
 * 메서드에 동기화 블럭을 지정해서 Thread-safe 를 보장합니다.
 * 게으른 초기화 방식이란 ? 컴파일 시점에 인스턴스를 생성하는 것이아니라,
 * 인스턴스가 필요한 시점에 요청 하여 동적 바인딩(dynamic binding)
 * (런타임시에 성격이 결정됨)을 통해 인스턴스를 생성하는 방식을 말합니다.
 */
public class LazyInitSingleton {

    private static LazyInitSingleton lazyInitInstance;

    private LazyInitSingleton() {}

    public static synchronized LazyInitSingleton getLazyInitInstance() {
        if (lazyInitInstance == null) {
            lazyInitInstance = new LazyInitSingleton();
        }
        return lazyInitInstance;
    }

}
