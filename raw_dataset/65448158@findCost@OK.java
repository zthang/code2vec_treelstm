private static int findCost(int[] a, List<Pair<Integer, Integer>> edges) {
    int cost = 0;
    for (Pair<Integer, Integer> e : edges) {
        cost += a[e.first];
        cost += a[e.second];
    }
    return cost;
}