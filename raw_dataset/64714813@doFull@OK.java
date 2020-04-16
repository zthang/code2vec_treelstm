static void doFull(int u, ArrayList<Integer>[] friends, HashSet<Integer> all, int symbol) {
    int st = 0;
    stack[st++] = u;
    while (st > 0) {
        time++;
        int v = stack[st - 1];
        st--;
        int tr = 0;
        for (int x : friends[v]) {
            tm[x] = time;
        }
        for (int w : all) {
            if (tm[w] < time) {
                visited[w] = true;
                target[w] = symbol;
                torem[tr++] = w;
                stack[st++] = w;
                connect++;
            }
        }
        // remove
        while (tr > 0) {
            int w = torem[tr - 1];
            tr--;
            all.remove(w);
        }
    }
}