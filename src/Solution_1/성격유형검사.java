package Solution_1;

import java.util.*;

public class 성격유형검사 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution(survey, choices));
    }
    public static String solution(String[] survey, int[] choices) {
        StringBuffer answer = new StringBuffer();
        List<String> typeTable = new ArrayList<>(List.of("RT", "CF", "JM", "AN"));
        Map<String, Integer> scoreMap = new HashMap<>();

        for(int i = 0; i < survey.length; i++) {
            String type = "";
            int choice = choices[i];
            if(choice > 4){
                type = survey[i].substring(1);
            } else if(choice < 4){
                type = survey[i].substring(0, 1);
            } else {
                continue;
            }

            try{
                int score = scoreMap.get(type);
                score += Math.abs(4 - choice);
                scoreMap.replace(type, score);
            } catch (NullPointerException ex){
                scoreMap.put(type, Math.abs(4 - choice));
            }
        }

        Set<String> setKey = scoreMap.keySet();
        for(String type : typeTable) {
            Set<String> set = new HashSet<>();
            for (String key : setKey) {
                if(type.contains(key)){
                    set.add(key);
                }
            }
            if(set.size() > 1){
                String maxStr = set.toArray()[0].toString();
                for(int i = 1; i < set.size(); i++) {
                    String tmp = set.toArray()[i].toString();
                    if(scoreMap.get(tmp) > scoreMap.get(maxStr)){
                        scoreMap.remove(maxStr);
                        maxStr = tmp;
                    }
                }
            }
        }

        out : for (String type : typeTable){
            for (String key : setKey){
                if(type.contains(key)) {
                    answer.append(type.substring(type.indexOf(key),type.indexOf(key) + 1));
                    continue out;
                }
            }
            answer.append(type.substring(0, 1));
        }

        return answer.toString();
    }
}
