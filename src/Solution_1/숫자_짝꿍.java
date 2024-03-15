package Solution_1;

import java.util.Arrays;

public class 숫자_짝꿍 {
    public static void main(String[] args){
        숫자_짝꿍 num = new 숫자_짝꿍();
        System.out.println(num.solution("100", "123450"));

    }
    public String solution(String X, String Y) {
        int[] xMatch = new int[10];
        int[] yMatch = new int[10];
        String[] xArr = X.split("");
        String[] yArr = Y.split("");
        for(String x : xArr) {
            xMatch[Integer.parseInt(x)]++;
        }
        for(String y : yArr) {
            yMatch[Integer.parseInt(y)]++;
        }

        int[] answerMatch = new int[10];
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < xMatch.length; i++) {
            answerMatch[i] = Math.min(xMatch[i], yMatch[i]);
        }

        for(int i = 9; i >= 0; i--) {
            while(answerMatch[i] > 0) {
                builder.append(i);
                answerMatch[i]--;
            }
        }

        String answer = builder.toString();

        if(answer.isEmpty()) {
            answer = "-1";
        }

        if(answer.startsWith("0")) {
            answer = "0";
        }

        return answer;
    }
}
