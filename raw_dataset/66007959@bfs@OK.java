public static void bfs(HashSet<Integer>[] hs, HashSet<Integer> visit, int p) {
    visit.add(p);
    HashSet<Integer> par = hs[p];
    for (Integer val : par) {
        if (!visit.contains(val)) {
            bfs(hs, visit, val);
        }
    }
}