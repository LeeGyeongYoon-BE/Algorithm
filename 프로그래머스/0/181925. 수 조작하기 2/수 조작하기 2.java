class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        for (int i = 1; i < numLog.length; i++) {
            int rst = numLog[i] - numLog[i - 1];
            if (rst == 1) {
                answer += "w";
            } else if (rst == -1) {
                answer += "s";
            } else if (rst == 10) {
                answer += "d";
            } else {
                answer += "a";
            }
        }
        return answer;
    }
}