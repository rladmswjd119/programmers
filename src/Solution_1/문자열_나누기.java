package Solution_1;


public class 문자열_나누기 {
    public static void main(String[] args) {
        문자열_나누기 strSplit = new 문자열_나누기();
        System.out.println(strSplit.solution("banana"));
    }
    public int solution(String s) {
        int answer = 0;
        String tmp = s;
        while (!tmp.isEmpty()){
            String[] strArr = tmp.split("");
            String firstWord = strArr[0];
            int match = 0;
            int noMatch = 0;
            for(String text : strArr){
                if(firstWord.equals(text)){
                    match++;
                } else {
                    noMatch++;
                }

                if(match == noMatch){
                    answer++;
                    break;
                }
            }
            if(match != noMatch && match + noMatch == tmp.length()){
                answer++;
            }
            tmp = tmp.substring(match + noMatch);
        }
        return answer;
    }
}
