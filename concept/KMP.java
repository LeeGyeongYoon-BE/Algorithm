// 문자열 검색 알고리즘
// 텍스트에서 패턴을 찾을 때 사용
// 브루트 포스와 달리, 불일치가 발생해도 이미 비교한 정보를 활용하여 탐색 효율을 높임

// idea
// 1. 접두사와 접미사 : 패턴의 접두사와 접미사가 일치하는 길이를 미리 계산 (lps 배열)
// 2. 불일치 발생 시 이동 : 이미 확인한 접두사 길이를 활용하여 불필요한 비교를 건너뜀

// LPS 배열(Longest Prefix Suffix)
// 패턴의 각 위치에서, 접두사와 접미사가 일치하는 최대 길이
// 패턴 : "ABABC"
// LPS : [0, 0, 1, 2, 0]
// 첫 2글짜 "AB"가 반복되므로, 불일치 시 바로 이동 가능

public class KMP {
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int[] lps = buildLPS(pattern);
        int n = text.length();
        int m = pattern.length();
        int i = 0, j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
            } // if
            if (j == m) { // 패턴 일치
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            } // if ~ else
        } // while
    } // main

    // LPS 배열 생성
    private static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // 접두사 길이
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                } // if ~ else
            } // if ~ else
        } // while
        return lps;
    } // buildLPS
} // class
