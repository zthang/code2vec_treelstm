void buildAssign(int[] cur, int idx) {
    if (idx == cur.length) {
        int ret = 0;
        Arrays.fill(done, false);
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            for (int k = 0; k < 21; k++) {
                if (done[k])
                    continue;
                int c1 = dominos[k][0];
                int c2 = dominos[k][1];
                if (cur[u] == c1 && cur[v] == c2) {
                    done[k] = true;
                    ret++;
                } else if (cur[u] == c2 && cur[v] == c1) {
                    done[k] = true;
                    ret++;
                }
            }
        }
        res = Math.max(res, ret);
        return;
    }
    for (int i = 1; i <= 6; i++) {
        cur[idx] = i;
        buildAssign(cur, idx + 1);
        cur[idx] = -1;
    }
}