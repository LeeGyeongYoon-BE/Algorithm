class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int[] plus = new int[included.length];
        for (int i = 0; i < plus.length; i++) {
            plus[i] = a + d * i;
        }
        for (int j = 0; j < included.length; j++) {
            if (included[j]) {
                answer += plus[j];
            }
        }
        return answer;
    }
}