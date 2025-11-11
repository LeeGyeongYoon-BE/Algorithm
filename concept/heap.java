// 완전이진트리를 기반으로 한 특수한 트리 구조
// 부모 노드와 자식 노드 간에 우선순위 조건을 만족
// 최대 힙(Max Heap) : 부모 >= 자식
// 최소 힙(Min Heap) : 부모 <= 자식

// insert(x) : 새로운 원소 x를 힙에 추가 후 힙 속성 유지
// poll() / remove() : 루트 노드 제거 후 힙 속성 유지
// peek() : 루트 노드 확인(최대 또는 최소 값)
// heapify() : 배열을 힙 구조로 변환

// 삽입 : 배열 마지막에 새 원소 추가 -> 부모와 비교하며 조건 만족할 때까지 위로 이동
// 삭제 : 루트 제거 -> 마지막 원소를 루트로 이동 -> 자식과 비교하며 조건 만족할 때까지 아래로 이동

// 최소 힙
import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);

        System.out.println("Root (min): " + minHeap.peek()); // 10
        System.out.println("Removed: " + minHeap.poll());    // 10
        System.out.println("Next root: " + minHeap.peek());  // 20
    } // main
} // class


// 최대 힙
import java.util.PriorityQueue;
import java.util.Collections;

public class MaxHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(20);

        System.out.println("Root (max): " + maxHeap.peek()); // 30
        System.out.println("Removed: " + maxHeap.poll());    // 30
        System.out.println("Next root: " + maxHeap.peek());  // 20
    } // main
} // class
