package test;

public class Test {
    public static void main(String[] args) {
        System.out.println(ClassName.genericMethod(1).getClass().getName());
        System.out.println(ClassName.genericMethod("제네릭").getClass().getName());

    }
}
