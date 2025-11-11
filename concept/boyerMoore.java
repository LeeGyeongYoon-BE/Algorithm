// 문자열 검색 알고리즘 중 하나
// 텍스트에서 패턴을 찾을 때 효율적으로 탐색
// 왼쪽에서 오른쪽으로 하나씩 비교하는 브루트 포스와 달리 패턴을 뒤에서부터 비교하며 불일치 시 최대한 많이 건너뛰어 검색

// idea
// 1. Bad Character Rule (불일치 문자 규칙) : 불일치가 발생한 문자에 따라 패턴을 최대한 많이 건너뛰기
// 2. Good Suffix Rule (좋은 접미사 규칙) : 불일치 직전까지 일치한 접미사 기준으로 패턴 이동

// 텍스트 : HERE IS A SIMPLE EXAMPLE
// 패턴 : EXAMPLE
// 1. 패턴의 끝 문자 E부터 비교
// 2. 불일치 발생 -> 불일치 문자가 패턴 안에 있으면 그 위치까지 이동, 없으면 전체 패턴 길이만큼 이동
// 3. 일치하면 한 글자씩 이동하며 계속 검색

// 단순 구현, Bad Character Rule
public class BoyerMoore {
    public static void main(String[] args) {
        String text = "HERE IS A SIMPLE EXAMPLE";
        String pattern = "EXAMPLE";

        int[] last = buildLast(pattern); // 각 문자 마지막 위치
        int n = text.length();
        int m = pattern.length();
        int i = m - 1; // 패턴 끝부터 비교

        while (i < n) {
            int j = m - 1;
            int k = i;
            while (j >= 0 && text.charAt(k) == pattern.charAt(j)) {
                k--; j--;
            } // while
            if (j < 0) {
                System.out.println("Pattern found at index " + (k + 1));
                i += m; // 패턴 길이만큼 이동
            } else {
                int lo = last[text.charAt(i)];
                i += Math.max(1, j - lo); // 이동 거리 계산
            } // if ~ else
        } // while
    } // main

    // 문자별 마지막 위치
    private static int[] buildLast(String pattern) {
        int[] last = new int[256]; // ASCII
        Arrays.fill(last, -1);
        for (int i = 0; i < pattern.length(); i++) {
            last[pattern.charAt(i)] = i;
        } // for
        return last;
    } // buildLast
} // class
