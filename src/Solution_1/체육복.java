package Solution_1;

import java.util.*;

/*
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
    이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 */
public class 체육복 {
    public static void main(String[] args){
        int[] lost = {2,4};
        int[] reserve = {3};

        체육복 workOut = new 체육복();
        System.out.println(workOut.solution(5, lost, reserve));
    }
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = 0;
                    reserve[j] = 0;
                    break;
                }
            }
        }

        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] != 0 && reserve[j] != 0) {
                    if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                        answer++;
                        lost[i] = 0;
                        reserve[j] = 0;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    /*
    전체 학생의 수는 2명 이상 30명 이하입니다.
    체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
    여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
     */
    private boolean checkParam(int n, int[] lost, int[] reserve){
        if(n < 2 || n > 30){
            return true;
        }

        if(checkArr(lost, n) && checkArr(reserve, n)){
            return true;
        }

        return false;
    }

    private boolean checkArr(int[] arr, int n) {
        int size = arr.length;
        if (size < 1 || size > n) {
            return true;

        }

        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        int setSize = set.size();
        if(size != setSize){
            return true;
        }

        return false;
    }
}
