List<Integer> solve(int u, int[] c, List<Integer>[] g) {
    List<Integer> list = new ArrayList<Integer>();
    for (int v : g[u]) {
        List<Integer> subList = solve(v, c, g);
        if (subList == null) {
            return null;
        }
        list.addAll(subList);
    }
    if (c[u] > list.size()) {
        return null;
    }
    list.add(c[u], u);
    return list;
}