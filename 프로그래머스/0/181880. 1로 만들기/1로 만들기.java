class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int i = 0; i < num_list.length; i++) {
            int target = num_list[i];
            int count = 0;
            while (target != 1) {
                if (target % 2 == 0) {
                    target /= 2;
                    count++;
                } else {
                    target = (target - 1) / 2;
                    count++;
                }
            }
            answer += count;
        }
        return answer;
    }
}