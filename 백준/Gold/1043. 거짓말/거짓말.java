import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        Set<Integer> truthSet = new HashSet<>();
        for (int i = 0; i < truthCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            truthSet.add(person);
        } // for

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) parties.add(new ArrayList<>());

        // 파티 참가자 읽기 및 union
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            List<Integer> party = parties.get(i);

            int first = Integer.parseInt(st.nextToken());
            party.add(first);

            for (int j = 1; j < k; j++) {
                int next = Integer.parseInt(st.nextToken());
                party.add(next);
                union(first, next);
            } // for - j
        } // for - i

        // 진실 아는 사람들의 루트 집합
        Set<Integer> truthRootSet = new HashSet<>();
        for (int person : truthSet) {
            truthRootSet.add(find(person));
        } // for

        int possible = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthRootSet.contains(find(person))) {
                    canLie = false;
                    break;
                } // if
            } // for - person
            if (canLie) possible++;
        } // for - party

        System.out.println(possible);
        br.close();
    } // main

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    } // find

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b){
                parent[b] = a;
            } else {
                parent[a] = b;
            } // if ~ else
        } // if
    } // union
} // class
