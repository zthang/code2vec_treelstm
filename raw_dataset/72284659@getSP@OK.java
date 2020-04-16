private static int[] getSP(List<Integer>[] g, int dest) {
    List<Integer>[] revG = new List[g.length];
    for (int i = 0; i < revG.length; i++) {
        revG[i] = new ArrayList<>();
    }
    for (int u = 0; u < g.length; u++) {
        for (int v : g[u]) {
            revG[v].add(u);
        }
    }
    int[] sp = new int[g.length];
    Arrays.fill(sp, Integer.MAX_VALUE);
    sp[dest] = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(dest);
    while (!q.isEmpty()) {
        int curr = q.poll();
        for (int v : revG[curr]) {
            if (sp[curr] + 1 < sp[v]) {
                sp[v] = sp[curr] + 1;
                q.add(v);
            }
        }
    }
    return sp;
}