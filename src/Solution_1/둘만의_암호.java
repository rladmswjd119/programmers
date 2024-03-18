package Solution_1;

import java.util.Arrays;

public class 둘만의_암호 {
    public static void main(String[] args) {
        둘만의_암호 password = new 둘만의_암호();
        System.out.println(password.solution("aukks", "wbqd", 5));
    }

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for(char c : s.toCharArray()) {
            char tmp = c;
            int idx = 0;
            while(idx < index) {
                tmp = tmp == 'z' ? 'a' : (char)(tmp + 1);
                if(!skip.contains(String.valueOf(tmp))) {
                    idx++;
                }
            }
            answer.append(tmp);
        }


        return answer.toString();
    }
}
