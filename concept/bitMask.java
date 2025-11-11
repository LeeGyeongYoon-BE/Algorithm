// 정수를 2진수 비트로 생각하여 상태를 표현하는 기법
// 주로 부분집합, 상태 DP, 플래그 처리 등에 사용
// 각 비트가 1이면 선택됨, 0이면 선택되지 않음으로 의미 부여

// & : AND, 두 비트 모두 1일 때 1 / 101 & 011 = 001
// ` : OR, 한 비트라도 1이면 1 / 101 ` 011 = 111
// ^ : XOR, 서로 다르면 1 / 101 ^ 011 = 110
// ~ : NOT, 비트 반전 / ~101 = 010 (3비트 기준)
// << : 왼쪽 쉬프트 / 001 << 2 = 100
// >> : 오른쪽 쉬프트 / 100 >> 2 = 001

// 부분집합 생성
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = arr.length;

        for (int mask = 0; mask < (1 << n); mask++) {
            System.out.print("{ ");
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                } // if
            } // for - i
            System.out.println("}");
        } // for - mask
    } // main
} // class

// 비트 DP 사용 예시 (TSP, 상태 저장)
int n = 4; // 노드 수
int[][] dist = new int[n][n]; // 거리
int[][] dp = new int[1<<n][n]; // dp[방문한 상태][현재 노드]

for(int i=0; i<(1<<n); i++) {
    Arrays.fill(dp[i], Integer.MAX_VALUE);
} // for
dp[1][0] = 0; // 시작점

for(int mask=1; mask<(1<<n); mask++) {
    for(int u=0; u<n; u++) {
        if((mask & (1<<u)) == 0) continue;
        for(int v=0; v<n; v++) {
            if((mask & (1<<v)) != 0) continue;
            dp[mask | (1<<v)][v] = Math.min(dp[mask | (1<<v)][v], dp[mask][u] + dist[u][v]);
        } // for - v
    } // for - u
} // for - mask
