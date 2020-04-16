void dfs(TreeMap<Long, Long> nxt, TreeMap<Long, Integer> groupFinder, long start, long cur, int mask, ArrayList<Long> path, TreeMap<Integer, ArrayList<Long>> cyc) {
    int cur_group = groupFinder.get(cur);
    if ((mask & 1 << cur_group) != 0) {
        if (cur == start) {
            path.add(start);
            cyc.put(mask, path);
        }
        return;
    }
    if (nxt.containsKey(cur)) {
        path.add(cur);
        dfs(nxt, groupFinder, start, nxt.get(cur), mask | 1 << cur_group, path, cyc);
    }
}