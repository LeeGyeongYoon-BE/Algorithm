class Solution {
    public String solution(String code) {
        String answer = "";
        String[] codex = new String[code.length()];
        for (int i = 0; i < code.length(); i++) {
            codex[i] = code.substring(i, i + 1);
        }
        int mode = 0;
        for (int idx = 0; idx < codex.length; idx++) {
            if (codex[idx].equals("1")) {
                mode = mode == 0 ? 1 : 0;
            } else {
                if (mode == 0 && idx % 2 == 0) {
                    answer += codex[idx];
                } 
                if (mode == 1 && idx % 2 != 0) {
                    answer += codex[idx];
                }
            }
        }
        
        
        
        if (answer.length() == 0) return "EMPTY";
        return answer;
    }
}