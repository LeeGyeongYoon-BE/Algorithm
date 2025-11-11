// 우선순위가 높은 요소를 먼저 제거하는 큐
// 내부적으로 힙 구조 사용

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙

        // 요소 추가
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        // 가장 작은 요소 확인
        System.out.println("Top element: " + pq.peek()); // 10

        // 제거
        System.out.println("Polled element: " + pq.poll()); // 10
        System.out.println("Polled element: " + pq.poll()); // 20
    } // main
} // class

