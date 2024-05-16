package Solution_1;

import java.util.*;

public class 키패드 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        키패드 key = new 키패드();
        System.out.println(key.solution(numbers, hand));
    }
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        Map<Integer, ArrayList<Integer>> keyPad = new HashMap<>();
        keyPad.put(10, new ArrayList<>(Arrays.asList(3, 0)));
        keyPad.put(0, new ArrayList<>(Arrays.asList(3, 1)));
        keyPad.put(11, new ArrayList<>(Arrays.asList(3, 2)));
        int key = 1;
        for(int i = 0; i <= 2; i++) {
            for(int j = 0; j <= 2; j++){
                keyPad.put(key, new ArrayList<>(Arrays.asList(i, j)));
                key++;
            }
        }

        int lHand = 10;
        int rHand = 11;
        for(int num : numbers){
            if(num == 2 || num == 5 || num == 8 || num == 0) {
                List<Integer> numList = keyPad.get(num);
                List<Integer> lList = keyPad.get(lHand);
                List<Integer> rList = keyPad.get(rHand);

                int lLen = Math.abs(lList.get(0) - numList.get(0)) + Math.abs(lList.get(1) - numList.get(1));
                int rLen = Math.abs(rList.get(0) - numList.get(0)) + Math.abs(rList.get(1) - numList.get(1));
                if(lLen == rLen){
                    if(hand.equals("right")){
                        answer.append("R");
                        rHand = num;
                    } else {
                        answer.append("L");
                        lHand = num;
                    }
                    continue;
                }
                if(lLen < rLen) {
                    answer.append("L");
                    lHand = num;
                }
                if(rLen < lLen) {
                    answer.append("R");
                    rHand = num;
                }
            }

            if(num == 1 || num == 4 || num == 7){
                answer.append("L");
                lHand = num;
                continue;
            }
            if(num == 3 || num == 6 || num == 9){
                answer.append("R");
                rHand = num;
            }

        }

        return answer.toString();
    }
}
