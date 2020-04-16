int[][] f(int[][] g, long[] arr) {
    int n = g.length;
    int[] set = new int[n];
    HashSet<Integer> need = new HashSet<>();
    for (int i = 0; i < n; i++) {
        if (arr[i] >= 0) {
            set[i] = (int) arr[i];
            need.add((int) arr[i]);
        } else {
            set[i] = -1;
        }
    }
    for (int i = 0; i < n; i++) {
        if (set[i] < 0) {
            continue;
        }
        int u = set[i];
        for (int v : g[u]) {
            set[v] = -inf;
        }
    }
    int x = 0, y = 0;
    for (int i = 0; i < n; i++) {
        if (need.contains((int) arr[i])) {
            if (set[i] < 0) {
                y++;
            } else {
                x++;
            }
        }
    }
    int[] a = new int[x], b = new int[y];
    for (int i = 0; i < n; i++) {
        if (need.contains((int) arr[i])) {
            if (set[i] < 0) {
                b[--y] = (int) arr[i];
            } else {
                a[--x] = (int) arr[i];
            }
        }
    }
    return new int[][] { a, b };
}