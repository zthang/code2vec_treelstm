private boolean dfs(int i, Map<Integer, List<Integer>> mp, Map<Integer, Integer> col, Map<String, Boolean> kCol) {
    col.put(i, 1);
    boolean isCyc = false;
    for (int j : mp.get(i)) {
        if (col.get(j) == 0) {
            isCyc = dfs(j, mp, col, kCol) || isCyc;
        } else if (col.get(j) == 1) {
            isCyc = true;
            kCol.put(i + "-" + j, Boolean.TRUE);
        }
    }
    col.put(i, 2);
    return isCyc;
}