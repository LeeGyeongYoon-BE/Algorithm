// 구간 합, 구간 최소/최대, 구간 합성 연산 등 배열의 구간 쿼리(Range Query)를 빠르게 처리하기 위한 트리 구조
// 배열을 분할하여 구간 단위로 값 저장 → 구간 연산 시 전체 탐색 대신 트리 탐색 가능
// 업데이트(O(log N)), 쿼리(O(log N)) 가능

// 크기: 배열의 2~4배 정도 필요
// 재귀적 구현이 일반적
// 변경 가능한 구간 쿼리에도 적합
// 구간 연산에 따라 트리 노드의 값 결정 (합, 최소, 최대 등)

// 구간 합
import java.io.*;
import java.util.*;

public class SegmentTree {
    static int[] tree;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        int N = 8;
        arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}; // 1-based index
        tree = new int[N * 4]; // 충분한 크기
        
        build(1, 1, N); // 세그먼트 트리 초기화
        System.out.println(query(1, 1, N, 3, 6)); // 3~6 구간 합
        update(1, 1, N, 4, 10); // 4번 인덱스 값을 10으로 업데이트
        System.out.println(query(1, 1, N, 3, 6)); // 3~6 구간 합 재조회
    } // main
    
    // 세그먼트 트리 초기화
    static int build(int node, int start, int end) {
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = build(node*2, start, mid) + build(node*2+1, mid+1, end);
    } // build
    
    // 구간 합 쿼리
    static int query(int node, int start, int end, int left, int right) {
        if(right < start || end < left) return 0; // 구간 벗어남
        if(left <= start && end <= right) return tree[node]; // 구간 포함
        int mid = (start + end) / 2;
        return query(node*2, start, mid, left, right) + query(node*2+1, mid+1, end, left, right);
    } // query
    
    // 값 업데이트
    static void update(int node, int start, int end, int idx, int val) {
        if(idx < start || end < idx) return; // 범위 밖
        if(start == end) {
            tree[node] = val;
            return;
        } // if
        int mid = (start + end) / 2;
        update(node*2, start, mid, idx, val);
        update(node*2+1, mid+1, end, idx, val);
        tree[node] = tree[node*2] + tree[node*2+1];
    } // update
} // class
