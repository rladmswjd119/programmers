package Solution_1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();

        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.print(t.solution(5, lost, reserve));
    }
    public int solution(int n, int[] lost, int[] reserve) {
            int answer = n;

            int[] clothList = new int[n];
            for(int re : reserve) {
                clothList[re - 1]++;
            }

            for(int lo : lost){
                clothList[lo - 1]--;
            }

            for(int i = 0; i < clothList.length; i++) {
                if(clothList[i] == 1) {
                    if(i - 1 >= 0 && clothList[i - 1] == -1) {
                        clothList[i]--;
                        clothList[i - 1]++;
                    } else if(i + 1 < clothList.length && clothList[i + 1] == -1) {
                        clothList[i]--;
                        clothList[i + 1]++;
                    } else if (clothList[i] < 0){
                        answer--;
                    }
                }
            }

            return answer;
    }
}
