package Solution_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
lottos는 길이 6인 정수 배열입니다.
lottos의 모든 원소는 0 이상 45 이하인 정수입니다.
    0은 알아볼 수 없는 숫자를 의미합니다.
    0을 제외한 다른 숫자들은 lottos에 2개 이상 담겨있지 않습니다.
    lottos의 원소들은 정렬되어 있지 않을 수도 있습니다.
win_nums은 길이 6인 정수 배열입니다.
win_nums의 모든 원소는 1 이상 45 이하인 정수입니다.
    win_nums에는 같은 숫자가 2개 이상 담겨있지 않습니다.
    win_nums의 원소들은 정렬되어 있지 않을 수도 있습니다.
 */
public class 로또 {
    public static void main(String[] args) {
        로또 lotto = new 로또();
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_numbers = {20, 9, 3, 45, 4, 35};
        System.out.print(Arrays.toString(lotto.solution(lottos, win_numbers)));
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> rank = new HashMap<>();
        rank.put(1, 6);
        rank.put(2, 5);
        rank.put(3, 4);
        rank.put(4, 3);
        rank.put(5, 2);

        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int min = 0;
        int miss = 0;
        for(int lot : lottos){
            if (lot == 0) {
                miss++;
                continue;
            }
            for (int win : win_nums) {
                if (lot < win) {
                    continue;
                }
                if (lot == win) {
                    min++;
                }
            }
        }

        int[] answer = new int[2];
        for(int i = 1; i <= 5; i++){
            if(min == rank.get(i)){
                answer[1] = i;
            }
            if(min + miss == rank.get(i)) {
                answer[0] = i;
            }
        }
        if(answer[1] == 0){
            answer[1] = 6;
        }
        if(answer[0] == 0) {
            answer[0] = 6;
        }
        return answer;
    }
}
