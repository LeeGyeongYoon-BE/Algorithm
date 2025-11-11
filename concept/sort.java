// 오름차순
@Override
public int compareTo(Elem other) {
    return num - other.num; // 음수이면 내가 먼저, 양수면 other이 먼저, 0이면 같음
}
