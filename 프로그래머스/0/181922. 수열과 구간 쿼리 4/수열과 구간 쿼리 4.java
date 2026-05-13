class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                int k = queries[i][2];
                if (j % k == 0) {
                    arr[j]++;
                }
            }
        }
        return arr;
    }
}