void rec(int n, int[] a, int pos) {
    if (pos == n) {
        TreeSet<Point> ts = new TreeSet<>(new PairComp());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (graph[i][j] == 1) {
                    if (!ts.contains(new Point(a[i], a[j])) && !ts.contains(new Point(a[j], a[i]))) {
                        ts.add(new Point(a[i], a[j]));
                    }
                }
            }
        }
        max = max(max, ts.size());
        return;
    }
    for (int i = 1; i <= 6; i++) {
        a[pos] = i;
        rec(n, a, pos + 1);
    }
}