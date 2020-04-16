private static int solve(Collection<Integer>[] adjList, int n) {
    TreeSet<Integer> notVisited = IntStream.range(0, n).boxed().collect(Collectors.toCollection(TreeSet::new));
    int count = 0;
    for (int i = 0; i < n; ++i) {
        if (notVisited.contains(i)) {
            dfs(i, adjList, notVisited);
            count++;
        }
    }
    return count - 1;
}