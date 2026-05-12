class Solution {
    public int[] solution(int[] arr, int[][] intervals) {

        int size = 0;
        for (int i = 0; i < intervals.length; i++) {
            size += intervals[i][1] - intervals[i][0] + 1;
        }

        int[] answer = new int[size];

        int idx = 0;

        // 구간의 값들 복사
        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            for (int j = start; j <= end; j++) {
                answer[idx++] = arr[j];
            }
        }

        return answer;
    }
}