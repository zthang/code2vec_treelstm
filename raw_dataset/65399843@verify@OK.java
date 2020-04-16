private static boolean verify(int n, int m, List<Pair<Integer, Integer>> edges) {
    HashSet<Integer>[] neighbors = new HashSet[n];
    for (int i = 0; i < n; i++) {
        neighbors[i] = new HashSet<>();
    }
    for (Pair<Integer, Integer> e : edges) {
        neighbors[e.first].add(e.second);
        neighbors[e.second].add(e.first);
    }
    if (edges.size() != m) {
        return false;
    }
    for (HashSet<Integer> s : neighbors) {
        if (s.size() < 2) {
            return false;
        }
    }
    return true;
}