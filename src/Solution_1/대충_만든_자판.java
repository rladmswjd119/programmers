package Solution_1;

import java.util.Arrays;

/*
keymap[i]는 i + 1번 키를 눌렀을 때 순서대로 바뀌는 문자를 의미합니다.
    예를 들어 keymap[0] = "ABACD" 인 경우 1번 키를 한 번 누르면 A, 두 번 누르면 B, 세 번 누르면 A 가 됩니다.
keymap의 원소의 길이는 서로 다를 수 있습니다.
keymap의 원소는 알파벳 대문자로만 이루어져 있습니다.
 */
public class 대충_만든_자판 {
    public static void main(String[] args) {
        String[] keymap = {"AGZ", "BSSS"};
        String[] targets = {"ASA", "BGZ"};
        대충_만든_자판 keybord = new 대충_만든_자판();
        System.out.println(Arrays.toString(keybord.solution(keymap, targets)));
    }
    public int[] solution(String[] keymap, String[] targets) {
        if(checkParma(keymap, targets)){
            return null;
        }

        int[] answer = new int[targets.length];
        int flag = 0;
        for(String target : targets) {
            for(String word : target.split("")){
                int min = keymap[0].indexOf(word);
                for(int i = 1; i < keymap.length; i++){
                    int findNum = keymap[i].indexOf(word);
                    if(findNum == -1){
                        continue;
                    }
                    if(min == -1 || findNum < min){
                        min = findNum;
                    }
                }
                if(min == -1) {
                    answer[flag] = -1;
                    break;
                }
                answer[flag] += min + 1;
            }
            flag++;
        }

        return answer;
    }

    /*
    1 ≤ keymap의 길이 ≤ 100
        1 ≤ keymap의 원소의 길이 ≤ 100
    1 ≤ targets의 길이 ≤ 100
        1 ≤ targets의 원소의 길이 ≤ 100
        targets의 원소는 알파벳 대문자로만 이루어져 있습니다.
     */
    private boolean checkParma(String[] keymap, String[] targets) {
        int keySize = keymap.length;
        if(keySize < 1 || keySize > 100){
            return true;
        }

        for(String key : keymap){
            int size = key.length();
            if(size < 1 || size > 100){
                return true;
            }
        }

        int targetSize = targets.length;
        if (targetSize < 1 || targetSize > 100){
            return true;
        }

        for(String target : targets){
            int size = target.length();
            if(size < 1 || size > 100){
                return true;
            }
            if(!target.matches("^[A-Z]*$")) {
                System.out.println("?");
                return true;
            }
        }
        return false;
    }
}
