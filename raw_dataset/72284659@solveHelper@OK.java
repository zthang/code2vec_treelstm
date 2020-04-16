private static int[] solveHelper(int idx) {
    int[] res = new int[2];
    if (idx == p.length - 1) {
        return res;
    }
    res[0] = Integer.MAX_VALUE;
    res[1] = Integer.MIN_VALUE;
    List<Integer> spNeighbors = new ArrayList<>();
    for (int v : g[p[idx]]) {
        if (sp[v] == sp[p[idx]] - 1) {
            spNeighbors.add(v);
        }
    }
    int[] neighborRes = solveHelper(idx + 1);
    for (int v : spNeighbors) {
        res[0] = Math.min(res[0], (v == p[idx + 1] ? 0 : 1) + neighborRes[0]);
        res[1] = Math.max(res[1], (v == p[idx + 1] ? 0 : 1) + neighborRes[1]);
    }
    return res;
}