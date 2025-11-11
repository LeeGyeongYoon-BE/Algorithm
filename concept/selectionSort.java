// 매 라운드마다 최솟값/최댓값을 찾아 위치 교환
// 배열의 앞쪽부터 정렬

// 1. 남은 배열에서 최솟값 인덱스 찾기
// 2. 현재 위치와 swap
// 3. 반복

public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            } // if
        } // for - j
        int temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    } // for - i
} // selectionSort
