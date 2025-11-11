import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        } // for

        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);

        br.close();
    } // main

    private static void quickSort(int[] A, int S, int E, int K) {
        int pivot = partition(A, S, E);
        if (pivot == K){
            return;
        } else if (K < pivot) {
            quickSort(A, S, pivot - 1, K);
        } else {
            quickSort(A, pivot + 1, E, K);
        } // if ~ else
    } // quickSort

    private static int partition(int[] A, int S, int E) {
        if (S + 1 == E) {
            if (A[S] > A[E]) {
                swap(A, S, E);
            } // if
            return E;
        } // if
        int M = (S + E) / 2;
        swap(A, S, M);
        int pivot = A[S];
        int i = S + 1;
        int j = E;
        while (i <= j) {
            while (pivot < A[j] && j > 0) {
                j--;
            } // while
            while (pivot > A[i] && i < A.length - 1) {
                i++;
            } // while
            if (i <= j) {
                swap(A, i++, j--);
            } // if
        } // while
        A[S] = A[j];
        A[j] = pivot;
        return j;
    } // partition

    private static void swap(int[] A, int S, int E) {
        int tmp = A[S];
        A[S] = A[E];
        A[E] = tmp;
    } // swap

} // class