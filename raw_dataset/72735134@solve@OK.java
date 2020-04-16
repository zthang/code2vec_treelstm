static long solve(long[] a, List<Edge> edges) {
    edges.sort(Comparator.comparingInt(e -> e.right));
    Map<Set<Integer>, Long> groups = new HashMap<>();
    Set<Integer> neighboringSet = new HashSet<>();
    for (int i = 0; i < edges.size(); i++) {
        Edge e = edges.get(i);
        neighboringSet.add(e.left);
        if (i == edges.size() - 1 || edges.get(i + 1).right != e.right) {
            if (groups.containsKey(neighboringSet)) {
                groups.put(neighboringSet, groups.get(neighboringSet) + a[e.right - 1]);
            } else {
                groups.put(neighboringSet, a[e.right - 1]);
            }
            neighboringSet = new TreeSet<>();
        }
    }
    long res = 0;
    for (Long sum : groups.values()) {
        res = gcd(sum, res);
    }
    return res;
}