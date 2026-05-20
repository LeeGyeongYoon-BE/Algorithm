class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        String[] str = my_string.split("");
        while (s <= e) {
            String t = str[s];
            str[s] = str[e];
            str[e] = t;
            s++;
            e--;
        }
        
        for (int i = 0; i < str.length; i++) {
            answer += str[i];
        }
        return answer;
    }
}