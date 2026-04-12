import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] challenger = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.0);
            } else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }

        ArrayList<Map.Entry<Integer, Double>> list =
                new ArrayList<>(fails.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1,
                               Map.Entry<Integer, Double> o2) {

                if (o2.getValue() > o1.getValue()) return 1;
                else if (o2.getValue() < o1.getValue()) return -1;
                else return o1.getKey() - o2.getKey();
            }
        });

        int[] result = new int[N];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}