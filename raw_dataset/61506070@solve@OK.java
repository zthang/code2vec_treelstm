void solve() {
    int n = scn.nextInt(), m = scn.nextInt();
    int[] from = new int[m], to = new int[m];
    DisJointSet dj = new DisJointSet(n);
    for (int i = 0; i < m; i++) {
        from[i] = scn.nextInt() - 1;
        to[i] = scn.nextInt() - 1;
        dj.union(from[i], to[i]);
    }
    if (dj.size != 1) {
        out.println(-1);
        return;
    }
    int[][] g = packU(n, from, to);
    long[] arr = new long[n], ans = new long[n];
    for (int i = 0; i < n; i++) {
        arr[i] = i;
    }
    int[][] ret = f(g, arr);
    if (ret[0].length == 0 || ret[1].length == 0) {
        out.println(-1);
        return;
    }
    for (int i = 0; i < n; i++) {
        arr[i] -= inf;
    }
    boolean found = false;
    {
        long[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < ret[0].length; i++) {
            copy[ret[0][i]] += inf;
        }
        for (int i = 0; i < ret[1].length; i++) {
            ans[ret[1][i]] = 1;
        }
        int[][] rv = f(g, copy);
        if (rv[0].length != 0 && rv[1].length != 0) {
            for (int i = 0; i < rv[0].length; i++) {
                ans[rv[0][i]] = 2;
            }
            for (int i = 0; i < rv[1].length; i++) {
                ans[rv[1][i]] = 3;
            }
            found = true;
        }
    }
    if (!found) {
        Arrays.fill(ans, 0);
        for (int i = 0; i < ret[1].length; i++) {
            arr[ret[1][i]] += inf;
        }
        for (int i = 0; i < ret[0].length; i++) {
            ans[ret[0][i]] = 1;
        }
        int[][] rv = f(g, arr);
        if (rv[0].length != 0 && rv[1].length != 0) {
            for (int i = 0; i < rv[0].length; i++) {
                ans[rv[0][i]] = 2;
            }
            for (int i = 0; i < rv[1].length; i++) {
                ans[rv[1][i]] = 3;
            }
            found = true;
        }
    }
    if (!found) {
        out.println(-1);
        return;
    }
    for (int i = 0; i < m; i++) {
        if (ans[from[i]] == ans[to[i]]) {
            out.println(-1);
            return;
        }
    }
    long x = 0, y = 0, z = 0;
    for (int i = 0; i < n; i++) {
        if (ans[i] == 1) {
            x++;
        } else if (ans[i] == 2) {
            y++;
        } else if (ans[i] == 3) {
            z++;
        }
    }
    if (x + y + z != n || x * (y + z) + y * z != m) {
        out.println(-1);
        return;
    }
    for (long a : ans) {
        out.print(a + " ");
    }
    out.println();
}