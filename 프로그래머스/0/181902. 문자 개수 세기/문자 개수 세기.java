class Solution {
    public int[] solution(String my_string) {

        int[] answer = new int[52];

        for (int i = 0; i < my_string.length(); i++) {

            char ch = my_string.charAt(i);

            // 대문자
            if (ch >= 'A' && ch <= 'Z') {
                answer[ch - 'A']++;
            }

            // 소문자
            else {
                answer[ch - 'a' + 26]++;
            }
        }

        return answer;
    }
}