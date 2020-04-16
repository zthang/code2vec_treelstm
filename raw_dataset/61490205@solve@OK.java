int[] solve(int n, int m, Set<Integer>[] g) {
    int[] type = new int[n];
    type[0] = 1;
    for (int i = 0; i < n; i++) {
        type[i] = g[0].contains(i) ? 2 : 1;
    }
    int t2 = -1;
    for (int i = 0; i < n; i++) if (type[i] == 2)
        t2 = i;
    if (t2 == -1)
        return null;
    for (int to : g[t2]) {
        if (type[to] == 2)
            type[to] = 3;
    }
    List<Integer>[] byType = new List[4];
    for (int i = 1; i <= 3; i++) byType[i] = new ArrayList<>();
    for (int i = 0; i < n; i++) byType[type[i]].add(i);
    for (int i = 1; i <= 3; i++) if (byType[i].isEmpty())
        return null;
    int edges = 0;
    for (int i = 0; i < n; i++) {
        for (int t = 1; t <= 3; t++) {
            if (t == type[i])
                continue;
            for (int j : byType[t]) {
                if (!g[i].contains(j))
                    return null;
                edges++;
            }
        }
    }
    if (edges != m * 2)
        return null;
    return type;
}