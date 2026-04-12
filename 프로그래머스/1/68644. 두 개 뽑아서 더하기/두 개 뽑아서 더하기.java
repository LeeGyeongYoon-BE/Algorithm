import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            } // for - j
        } // for - i
        
        int[] result = new int[set.size()];
        int idx = 0;

        for (Integer num : set) {
            result[idx++] = num;
        }
        Arrays.sort(result);

        return result;
    }
}