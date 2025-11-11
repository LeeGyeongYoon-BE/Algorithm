// 인접한 두 원소를 비교하여 순서를 바꾸는 단순 정렬
// 큰 값이 점점 뒤로 이동

// 1. 외부 루프 : 정렬할 라운드 수
// 2. 내부 루프 : 인접한 두 원소 비교
// 3. swap : 왼쪽이 크면 오른쪽과 교환
// 4. swap이 없으면 정렬 종료

public static void bubbleSort(int[] arr) {
    int n = arr.length;
    boolean swapped;

    for (int i = 0; i < n - 1; i++) {
        swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            } // if
        } // for - j
        if (!swapped) break;
    } // for - i
} // bubbleSort
