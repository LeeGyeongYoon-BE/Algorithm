// 문제를 해결할 때 현재 상황에서 가장 좋아 보이는 선택을 반복하는 방법
// 한 번의 선택이 최적해에 영향을 준다는 조건에서 사용 가능
// 탐욕법이라고도 불림

// idea
// 1. 문제를 작은 단위로 나눈다.
// 2. 각 단위에서 최적이라고 생각되는 선택을 한다
// 3. 다음 단계로 넘어가 반복
// 4. 전체 문제의 최적해를 구할 수 있는지 문제 검증 필수

// 회의실 배정 예시
import java.io.*;
import java.util.*;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start, end;
        Meeting(int start, int end) { this.start = start; this.end = end; }
        public int compareTo(Meeting o) { return this.end - o.end; } // 종료시간 기준 정렬
    } // Meeting

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        } // for

        Arrays.sort(meetings); // 종료시간 기준 정렬

        int count = 0;
        int lastEnd = 0;
        for (Meeting m : meetings) {
            if (m.start >= lastEnd) { // 이전 회의와 겹치지 않으면
                count++;
                lastEnd = m.end;
            } // if
        } // for

        System.out.println(count);
        br.close();
    } // main
} // class
