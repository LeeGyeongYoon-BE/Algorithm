class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        int size = 0;
        if (my_string.length() % m == 0) {
            size = my_string.length() / m;
        } else {
            size = my_string.length() / m + 1;
        }
        String[][] arr = new String[size][m];
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = my_string.substring(count, count + 1);
                count++;
            }
        }
        
        for (int i = 0; i < size; i++) {
            answer += arr[i][c - 1];
        }
        return answer;
    }
}