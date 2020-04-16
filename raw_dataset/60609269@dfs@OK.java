static void dfs(Map<Integer, Set<Integer>> map, boolean[] b, int x) {
    b[x] = true;
    xx++;
    for (int y : map.get(x)) {
        if (!b[y]) {
            dfs(map, b, y);
        }
    }
}