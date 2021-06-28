package pattern.singleton;

/*
* 싱글톤 패턴 
* 인스턴스가 오직 1개만 생성되야 하는경우 사용되는패턴
* 하나의 인스턴스를 메모리에 등록해서 여러 스레드가 동시에 해당 인스턴스를
* 공유하여 사용하게끔 할 수 있으므로,
* 요청이 많은 곳에서 사용하면 효율이 높다.
*
* 주의 해야할점 : 동시성 (Concurrency) 문제를 고려해서 싱글턴을 설계해야한다.
*
* 이른 초기화 방식은, static 키워드의 특징을 이용해서 클래스 로더가 초기화 하는 시점에서
* 정적 바인딩(static binding)(컴파일 시점에서 성격이 결정됨)을 통해
* 해당 인스턴스를 메모리에 등록해서 사용하는 것입니다.
* 이른 초기화 방식은 클래스 로더에 의해 클래스가 최초로 로딩 될 때
* 객체가 생성되기때문에 Thread-safe 합니다.
* 싱글턴 구현 시 중요한 점이, 멀티 스레딩 환경에서도 동작 가능
*
*/

/**
 * 이른 초기화 Eger Initialization ( thread-safe)
 * 싱글턴 패턴 공통적인 특징은
 * private constructor 을 가진다는 것과
 * static method 를 사용한다는것이다.
 */
public class EagInitSingleton {

    private static EagInitSingleton eagInitSingletonInstance = new EagInitSingleton();

    private EagInitSingleton() {}

    public static EagInitSingleton getInstance() {
        return eagInitSingletonInstance;
    }

}
