// 후입선출(LIFO, Last In First Out) 구조
// 마지막에 들어간 데이터가 가장 먼저 나옴

// push(x) : 스택에 요소 x 추가
// pop() : 스택에서 가장 위 요소 제거 및 반환
// peek() / top() : 스택의 가장 위 요소 확인
// isEmpty() : 스택이 비어있는지 확

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 요소 추가
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // 스택의 가장 위 확인
        System.out.println("Top element: " + stack.peek()); // 30

        // 요소 제거
        System.out.println("Popped element: " + stack.pop()); // 30
        System.out.println("Popped element: " + stack.pop()); // 20

        // 스택이 비어있는지 확인
        System.out.println("Is stack empty? " + stack.isEmpty()); // false
    } // main
} // class
