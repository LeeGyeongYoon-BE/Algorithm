import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        for (int i = 0; i < query.length; i++) {
            
            if (i % 2 == 0) {
                // 뒤쪽 삭제
                arr = Arrays.copyOfRange(arr, 0, query[i] + 1);
                
            } else {
                // 앞쪽 삭제
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
        }
        
        return arr;
    }
}