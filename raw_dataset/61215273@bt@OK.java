static void bt(int cur) {
    if (cur == assn.length) {
        boolean[][] used = new boolean[6][6];
        int val = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int edge : graph[i]) {
                if (assn[edge] < assn[i])
                    continue;
                if (!used[assn[edge]][assn[i]]) {
                    used[assn[edge]][assn[i]] = true;
                    val++;
                }
            }
        }
        best = Math.max(val, best);
    } else {
        for (int i = 0; i < 6; i++) {
            assn[cur] = i;
            bt(cur + 1);
        }
    }
}