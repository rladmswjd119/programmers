package Solution_1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public static void main(String[] args){
        완주하지_못한_선수 m = new 완주하지_못한_선수();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(m.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for(String pa : participant){
            if(map.get(pa) != null) {
                map.replace(pa, map.get(pa) + 1);
                continue;
            }
                map.put(pa, 1);
        }

        for(String co : completion) {
            map.replace(co, map.get(co) - 1);
        }

        for(String pa : participant) {
            if(map.get(pa) == 1) {
                answer = pa;
            }
        }

        return answer;
    }
}
