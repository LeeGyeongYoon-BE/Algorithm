import java.io.*;

public class Main {
    static class Node {
        int data;
        Node leftChild, rightChild;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // 입력으로 트리 구성
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int num = Integer.parseInt(input);
            insert(num);
        }

        // 후위 순회 출력
        postOrder(root);
    }

    // 트리에 노드 삽입 (BST 규칙)
    static void insert(int data) {
        root = insertNode(root, data);
    }

    static Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.leftChild = insertNode(node.leftChild, data);
        } else {
            node.rightChild = insertNode(node.rightChild, data);
        }

        return node;
    }

    // 후위 순회 (Left → Right → Root)
    static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.println(node.data);
    }
}
