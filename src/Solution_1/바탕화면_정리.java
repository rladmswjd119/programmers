package Solution_1;

import java.util.Arrays;

public class 바탕화면_정리 {
    public static void main(String[] args) {
        String[] walllpaper = {"#.", ".."};
        System.out.println(Arrays.toString(solution(walllpaper)));
    }
    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        answer[2] = wallpaper.length;
        int max = 0;
        int min = 51;
        int idx = -1;

        for(String s : wallpaper) {
            idx++;
            if(s.contains("#")){
                answer[0] = idx;
                break;
            }
        }

        while (!wallpaper[answer[2] - 1].contains("#")){
            answer[2] = answer[2] - 1;
        }

        for(String s : wallpaper){
            if(s.contains("#")){
                min = Math.min(min, s.indexOf("#"));
                max = Math.max(max, s.lastIndexOf("#"));
            }
        }
        answer[1] = min;
        answer[3] = max + 1;

        return answer;
    }

}
