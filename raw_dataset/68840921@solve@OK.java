private Pair<Long, Long> solve(Graphs.Edge[] edges, List<Integer>[] adjLists) {
    final int n = adjLists.length;
    int[] subtrees = new int[n - 1];
    dfs(subtrees, edges, adjLists, 0, -1);
    long min = 0, max = 0;
    for (int i = 0; i < subtrees.length; i++) {
        long a = subtrees[i];
        long b = n - a;
        max += edges[i].cost * Math.min(a, b);
        min += edges[i].cost * (a % 2);
    }
    return Pair.of(min, max);
}