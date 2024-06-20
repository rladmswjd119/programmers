package Solution_1;

import java.util.stream.Collectors;

public class 신규_아이디_추천 {
    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"));
    }
    public static String solution(String new_id) {
        String stepOneId = changeSmall(new_id);
        String stepTwoId = impossibleWordDelete(stepOneId);
        String stepThrId = removeDupTimelines(stepTwoId);
        String stepFourId = firstLastTimeLinesRemove(stepThrId);
        String stepFiveId = emptyWord(stepFourId);
        String stepSixId = reductionLen(stepFiveId);
        String finalId = finalCheck(stepSixId);

        return finalId;
    }

    private static String changeSmall(String newId) {
        return newId.chars().mapToObj(num -> String.valueOf((char)num).toLowerCase()).collect(Collectors.joining());
    }

    private static String impossibleWordDelete(String stepOneId) {
        return stepOneId.chars().filter(num -> (num >= 97 && num <= 122) || (num <= 57 && num >= 48) || num == 45 || num == 46 || num == 95)
                                .mapToObj(num -> String.valueOf((char)num)).collect(Collectors.joining());
    }

    private static String removeDupTimelines(String stepTwoId) {
        while(stepTwoId.contains("..")){
            stepTwoId = stepTwoId.replace("..", ".");
        }

        return stepTwoId;
    }

    private static String firstLastTimeLinesRemove(String stepThrId) {
        while(stepThrId.startsWith(".") || stepThrId.endsWith(".")){
            if(stepThrId.startsWith(".")) {
                stepThrId = stepThrId.substring(1);
            } else {
                stepThrId = stepThrId.substring(0, stepThrId.length() - 1);
            }
        }

        return stepThrId;
    }

    private static String emptyWord(String stepFourId){
        return stepFourId.isEmpty() ? "a" : stepFourId;
    }

    private static String reductionLen(String stepFiveId) {
        if(stepFiveId.length() >= 16){
            stepFiveId = stepFiveId.substring(0, 15);
        }

        while(stepFiveId.endsWith(".")){
            stepFiveId = stepFiveId.substring(0, stepFiveId.length() - 1);
        }

        return stepFiveId;
    }

    private static String finalCheck(String stepSixId) {
        StringBuilder stb = new StringBuilder(stepSixId);
        while(stb.length() <= 2){
            String tmp = stb.reverse().substring(0, 1);
            stb.reverse().append(tmp);
        }

        return stb.toString();
    }
}
