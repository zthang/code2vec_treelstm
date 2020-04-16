private static List<String> solve(int n, int m, int[] as) {
    if (n == 2 || m < n) {
        return Arrays.asList("-1");
    }
    int sum = 0;
    List<String> edges = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        edges.add(String.format("%d %d", i + 1, (i + 1) % n + 1));
        sum += 2 * as[i];
    }
    List<Chain> chains = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        chains.add(new Chain(as[i], i));
    }
    Collections.sort(chains);
    for (int i = n; i < m; i++) {
        Chain c1 = chains.get(0);
        Chain c2 = chains.get(1);
        edges.add(String.format("%d %d", c1.index + 1, c2.index + 1));
        sum += c1.weight + c2.weight;
    }
    List<String> answers = new ArrayList<>();
    answers.add("" + sum);
    answers.addAll(edges);
    return answers;
}