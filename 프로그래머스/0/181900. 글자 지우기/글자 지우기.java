class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] arr = new String[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            arr[i] = my_string.substring(i, i + 1);
        }
        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = " ";
        }
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(" ")) {
                answer += arr[i];
            }
        }
        return answer;
    }
}