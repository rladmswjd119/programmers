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
        Stack<Integer> stack = new Stack<>();
        for(int material : ingredient){
            stack.push(material);
            if(stack.size() >= 4
                    && stack.get(stack.size() - 1) == 1
                    && stack.get(stack.size() - 2) == 3
                    && stack.get(stack.size() - 3) == 2
                    && stack.get(stack.size() - 4) == 1){

                answer++;
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }
        return answer;
    }
}
