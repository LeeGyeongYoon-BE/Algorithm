// 문제를 작은 하위 문제로 나누어 각각 해결한 후, 결과를 합쳐서 전체 문제를 해결하는 알고리즘 기법
// 재귀 구조와 함께 사용되는 경우가 많음
// 대표적 문제: 정렬, 최대/최소 찾기, 이진 탐색, 행렬 곱셈

// 1. 분할(Divide): 문제를 작은 하위 문제로 나눔
// 2. 정복(Conquer): 각 하위 문제를 재귀적으로 해결
// 3. 병합(Merge): 하위 문제의 결과를 합쳐 전체 문제를 해결

// 배열의 합 구하기
static int sum(int[] arr, int left, int right) {
    if (left == right) return arr[left]; // 단일 원소
    int mid = (left + right) / 2;
    int leftSum = sum(arr, left, mid);
    int rightSum = sum(arr, mid + 1, right);
    return leftSum + rightSum; // 병합
} // sum

public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(sum(arr, 0, arr.length - 1)); // 15
} // main
