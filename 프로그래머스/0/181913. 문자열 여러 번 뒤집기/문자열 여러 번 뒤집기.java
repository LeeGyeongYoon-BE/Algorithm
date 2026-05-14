class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        String[] str = my_string.split("");
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            while (start <= end) {
                String t = str[start];
                str[start] = str[end];
                str[end] = t;
                start++;
                end--;
            }
        }
        for (int i = 0; i < str.length; i++) {
            answer += str[i];
        }
        return answer;
    }
}