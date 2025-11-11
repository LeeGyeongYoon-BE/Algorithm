// 분할 정복 전략
// 배열을 반으로 나누고, 재귀적으로 정렬 후 합침

// 1. 배열을 반으로 나눔
// 2. 좌우를 재귀 정렬
// 3. 정렬된 두 배열 합치기

public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    } // if
} // mergeSort

public static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) temp[k++] = arr[i++];
        else temp[k++] = arr[j++];
    } // while
    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];
    for (i = 0; i < temp.length; i++) arr[left + i] = temp[i];
} // merge
