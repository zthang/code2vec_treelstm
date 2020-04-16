boolean tryWith(int colors) {
    // if (mem[colors] != 0) return mem[colors] == 1;
    int i, j, k;
    for (k = 0; k < (colors > 1 ? 17 : 1); ++k) {
        for (int[] ed : edges) {
            int[] oth = contains[ed[1]][ed[0]];
            if (oth == null)
                ed[2] = rn.nextInt(Integer.MAX_VALUE >> 2) % colors + 1;
            else if (ed[0] < ed[1]) {
                int col1, col2;
                do {
                    col1 = rn.nextInt(Integer.MAX_VALUE >> 2) % colors + 1;
                    col2 = rn.nextInt(Integer.MAX_VALUE >> 2) % colors + 1;
                } while (colors > 1 && col1 == col2);
                ed[2] = col1;
                oth[2] = col2;
            }
        }
        // for (int[] e : edges) System.out.print(e[2] + " ");
        boolean cycle = false;
        for (j = 1; j <= colors && !cycle; ++j) {
            for (int[] e : edges) if (e[2] == j) {
                graph[e[0]].add(e[1]);
            }
            // for (i = 0; i < N; ++i) System.out.print(Arrays.toString(edges[i]));
            // System.out.println();
            HashSet<Integer> ws = new HashSet<>(), gs = new HashSet<>(), bs = new HashSet<>();
            for (i = 0; i < N; ++i) ws.add(i);
            while (!ws.isEmpty()) {
                if (dfs(ws.iterator().next(), ws, gs, bs)) {
                    cycle = true;
                    break;
                }
            }
            for (i = 0; i < N; ++i) graph[i].clear();
        }
        // System.out.println("Cycle: " + cycle);
        if (!cycle)
            return true;
    }
    // mem[colors] = -1;
    return false;
}