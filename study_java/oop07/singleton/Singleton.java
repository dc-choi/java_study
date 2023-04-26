package oop07.singleton;

/**
 * 싱글톤 패턴 구현 순서
 * 1. 생성자를 private로 작성한다.
 * 2. 자기 자신을 참조할 수 있는 변수를 선언후 private static 지정
 * 3. 자기 자신의 인스턴스를 반환하는 getter 메서드 작성
 * 4. Singleton.getInstance()로 인스턴스 호출
 */
public class Singleton {
	private static Singleton singleton = null;
	
	private Singleton() {}

	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		
		return singleton;
	}

	public static void setSingleton(Singleton singleton) {
		Singleton.singleton = singleton;
	}
}
