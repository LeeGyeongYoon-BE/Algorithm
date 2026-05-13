import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                int k = queries[i][2];
                if (arr[j] > k) {
                    pq.offer(arr[j]);
                }
            }
            if (!pq.isEmpty()) {
                answer[i] = pq.poll();
            } else {
                answer[i] = -1;
            }
        }
        return answer;
    }
}