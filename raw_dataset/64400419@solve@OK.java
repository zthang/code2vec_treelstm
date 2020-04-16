private int solve(int n, int m, int[] a, int[] b) {
    int[][] g = buildGraph(n, m, a, b);
    int comps = 0;
    TreeSet<Integer> available = new TreeSet<>();
    for (int i = 0; i < n; i++) {
        available.add(i);
    }
    while (!available.isEmpty()) {
        int v0 = available.pollFirst();
        TreeSet<Integer> busy0 = new TreeSet<Integer>();
        for (int vto : g[v0]) {
            if (available.contains(vto)) {
                available.remove(vto);
                busy0.add(vto);
            }
        }
        while (!available.isEmpty()) {
            int v1 = available.pollFirst();
            TreeSet<Integer> busy1 = new TreeSet<Integer>();
            for (int vto : g[v1]) {
                if (busy0.contains(vto)) {
                    busy1.add(vto);
                }
            }
            for (Integer vto : busy0) {
                if (!busy1.contains(vto)) {
                    available.add(vto);
                }
            }
            busy0 = busy1;
        }
        comps++;
        available = busy0;
    }
    return comps - 1;
}