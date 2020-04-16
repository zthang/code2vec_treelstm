private static List<Pair<Integer, Integer>> solve(int[] a, int m) {
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
    return null;
}