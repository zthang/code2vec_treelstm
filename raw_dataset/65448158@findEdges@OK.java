private static List<Pair<Integer, Integer>> findEdges(int[] a, int m) {
    int n = a.length;
    if (n <= 2 || m < n) {
        return null;
    }
    if (n == m) {
        List<Pair<Integer, Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            answer.add(Pair.of(i, (i + 1) % n));
        }
        return answer;
    }
    Integer[] indices = new Integer[n];
    for (int i = 0; i < n; i++) {
        indices[i] = i;
    }
    Arrays.sort(indices, Comparator.comparingInt((Integer i) -> a[i]));
    Deque<Integer> big = new ArrayDeque<>();
    for (int i = 2; i < n; i++) {
        big.add(indices[i]);
    }
    int min = indices[0];
    int min2 = indices[1];
    int degMin = Math.min(m - (n - 1 + 1) / 2, 2 * m - 2 * (n - 1));
    int degMin2 = 2 * m - 2 * (n - 2) - degMin;
    // System.out.format("n=%d, m=%d, degMin=%d, degMin2=%d%n", n, m, degMin, degMin2);
    List<Pair<Integer, Integer>> answer = new ArrayList<>();
    while (degMin2 > 2) {
        answer.add(Pair.of(min, min2));
        degMin--;
        degMin2--;
    }
    while (degMin > 2) {
        if (big.size() < 2)
            break;
        int i = big.pollFirst(), j = big.pollFirst();
        answer.add(Pair.of(min, i));
        answer.add(Pair.of(min, j));
        answer.add(Pair.of(i, j));
        degMin -= 2;
    }
    List<Integer> remaining = new ArrayList<>();
    remaining.addAll(big);
    remaining.add(min);
    remaining.add(min2);
    Util.ASSERT(degMin == 2);
    Util.ASSERT(degMin2 == 2);
    Util.ASSERT(m - answer.size() == remaining.size());
    for (int i = 0; i < remaining.size(); i++) {
        answer.add(Pair.of(remaining.get(i), remaining.get((i + 1) % remaining.size())));
    }
    return answer;
}