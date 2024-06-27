package test;

class ClassName<E> {

    private E element;	// 제네릭 타입 변수

    void set(E element) {	// 제네릭 파라미터 메소드
        this.element = element;
    }

    E get() {	// 제네릭 타입 반환 메소드
        return element;
    }

    static <T> T genericMethod(T o) {	// 제네릭 메소드
        return o;
    }
}
