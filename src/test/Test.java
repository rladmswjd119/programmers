package test;

public class Test {
    public static void main(String[] args) {
        InStack<Integer> st = new InStack<>(10);
        st.inPush(3);
        st.inPush(43);
        st.inPush(35);
        st.inPush(234);

        st.inClear();
        st.getDump();
    }
}
