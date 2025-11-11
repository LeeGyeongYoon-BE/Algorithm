// 자릿수 단위로 정렬하여 전체 배열을 정렬하는 방식
// LSD -> 가장 낮은 자리수부터 정렬
// MSD -> 갖아 높은 자리수부터 정렬

// 1. 최대 자릿수 확인 -> 몇 번 반복할지 결정
// 2. 현재 자릿수 기준으로 Counting Sort 수행
// 3. 배여레 다시 복사 -> 안정 정렬 유지
// 4. 자릿수를 한 단계씩 올려 반복

// LSD 방식, 0~9 정수 기준
import java.util.*;

public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int exp = 1; // 10^0 = 1, 10^1 = 10 ...
        int n = arr.length;
        int[] output = new int[n];

        while (max / exp > 0) {
            int[] count = new int[10];

            // 자릿수 기반 카운팅
            for (int i = 0; i < n; i++) {
                count[(arr[i] / exp) % 10]++;
            } // for

            // 누적합
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            } // for

            // 뒤에서부터 출력 배열에 배치 (안정 정렬)
            for (int i = n - 1; i >= 0; i--) {
                int idx = (arr[i] / exp) % 10;
                output[count[idx] - 1] = arr[i];
                count[idx]--;
            } // for

            // 원래 배열에 복사
            System.arraycopy(output, 0, arr, 0, n);

            exp *= 10;
        } // while
    } // radixSort
} // class
