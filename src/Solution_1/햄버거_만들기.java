package Solution_1;

import java.util.Stack;

public class 햄버거_만들기 {
    public static void main(String[] args){
        햄버거_만들기 ham = new 햄버거_만들기();
        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println(ham.solution(ingredient));
    }
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        for(int in : ingredient) {
            stk.push(in);
            if(stk.size() >= 4
            && stk.get(stk.size() - 4) == 1
            && stk.get(stk.size() - 3) == 2
            && stk.get(stk.size() - 2) == 3
            && stk.get(stk.size() - 1) == 1){
                answer++;
                stk.pop();
                stk.pop();
                stk.pop();
                stk.pop();
            }
        }
        return answer;
    }
}
