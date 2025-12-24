import java.io.*;
import java.util.*;

public class Main {

    static int[] preorder, inorder;
    static Map<Integer, Integer> inIndex;
    static StringBuilder sb;

    static void postOrder(int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) return;

        int root = preorder[preStart];
        int rootIdx = inIndex.get(root);
        int leftSize = rootIdx - inStart;

        // 왼쪽 서브트리
        postOrder(preStart + 1, inStart, rootIdx - 1);
        // 오른쪽 서브트리
        postOrder(preStart + leftSize + 1, rootIdx + 1, inEnd);
        // 루트
        sb.append(root).append(' ');
    } // postOrder

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            preorder = new int[n];
            inorder = new int[n];
            inIndex = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            } // for

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
                inIndex.put(inorder[i], i);
            } // for

            postOrder(0, 0, n - 1);
            sb.append('\n');
        } // while

        System.out.print(sb.toString());
    } // main
} // class
