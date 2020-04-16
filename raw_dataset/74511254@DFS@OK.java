private static void DFS(int par, int cur) {
    if (!check[cur].isEmpty()) {
        for (int i : check[cur]) {
            boolean valid = true;
            for (int j : query[i]) {
                if (!onPath[j]) {
                    valid = false;
                    break;
                }
            }
            ans[i] = valid;
        }
    }
    for (int i = head[cur]; i != 0; i = prev[i]) if (to[i] != par)
        onPath[to[i]] = true;
    for (int i = head[cur]; i != 0; i = prev[i]) if (to[i] != par)
        DFS(cur, to[i]);
    for (int i = head[cur]; i != 0; i = prev[i]) if (to[i] != par)
        onPath[to[i]] = false;
}