void solve() {
    int n = ni();
    long[] a = new long[n + 1];
    long[] b = new long[n + 1];
    long[] c = new long[n + 1];
    for (int i = 1; i <= n; i++) a[i] = ni();
    for (int i = 1; i <= n; i++) b[i] = ni();
    for (int i = 1; i <= n; i++) c[i] = ni();
    arr = new ArrayList[n + 1];
    fa = new int[n + 1];
    long ans = 0;
    for (int i = 0; i <= n; i++) arr[i] = new ArrayList<Integer>();
    int flag = 0;
    for (int i = 0; i < n - 1; i++) {
        int u = ni();
        int v = ni();
        arr[u].add(v);
        arr[v].add(u);
        if (arr[u].size() >= 3 || arr[v].size() >= 3)
            flag = 1;
    }
    if (flag == 1)
        out.println("-1");
    else {
        int start = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i].size() == 1) {
                start = i;
                break;
            }
        }
        boolean[] visited = new boolean[n + 1];
        dfs(visited, start);
        // abc
        ans = a[fa[0]] + b[fa[1]] + c[fa[2]];
        int[] clr = new int[n + 1];
        int[] col = new int[n + 1];
        clr[fa[0]] = 1;
        clr[fa[1]] = 2;
        clr[fa[2]] = 3;
        for (int i = 3; i < n; i++) {
            if (i % 3 == 0) {
                ans += a[fa[i]];
                clr[fa[i]] = 1;
            } else if (i % 3 == 1) {
                ans += b[fa[i]];
                clr[fa[i]] = 2;
            } else {
                ans += c[fa[i]];
                clr[fa[i]] = 3;
            }
        }
        long min = ans;
        col = clr.clone();
        ans = a[fa[0]] + c[fa[1]] + b[fa[2]];
        clr[fa[0]] = 1;
        clr[fa[1]] = 3;
        clr[fa[2]] = 2;
        for (int i = 3; i < n; i++) {
            if (i % 3 == 0) {
                ans += a[fa[i]];
                clr[fa[i]] = 1;
            } else if (i % 3 == 1) {
                ans += c[fa[i]];
                clr[fa[i]] = 3;
            } else {
                ans += b[fa[i]];
                clr[fa[i]] = 2;
            }
        }
        if (ans < min) {
            min = ans;
            col = clr.clone();
        }
        ans = b[fa[0]] + a[fa[1]] + c[fa[2]];
        clr[fa[0]] = 2;
        clr[fa[1]] = 1;
        clr[fa[2]] = 3;
        for (int i = 3; i < n; i++) {
            if (i % 3 == 0) {
                ans += b[fa[i]];
                clr[fa[i]] = 2;
            } else if (i % 3 == 1) {
                ans += a[fa[i]];
                clr[fa[i]] = 1;
            } else {
                ans += c[fa[i]];
                clr[fa[i]] = 3;
            }
        }
        if (ans < min) {
            min = ans;
            col = clr.clone();
        }
        ans = b[fa[0]] + c[fa[1]] + a[fa[2]];
        clr[fa[0]] = 2;
        clr[fa[1]] = 3;
        clr[fa[2]] = 1;
        for (int i = 3; i < n; i++) {
            if (i % 3 == 0) {
                ans += b[fa[i]];
                clr[fa[i]] = 2;
            } else if (i % 3 == 1) {
                ans += c[fa[i]];
                clr[fa[i]] = 3;
            } else {
                ans += a[fa[i]];
                clr[fa[i]] = 1;
            }
        }
        if (ans < min) {
            min = ans;
            col = clr.clone();
        }
        ans = c[fa[0]] + a[fa[1]] + b[fa[2]];
        clr[fa[0]] = 3;
        clr[fa[1]] = 1;
        clr[fa[2]] = 2;
        for (int i = 3; i < n; i++) {
            if (i % 3 == 0) {
                ans += c[fa[i]];
                clr[fa[i]] = 3;
            } else if (i % 3 == 1) {
                ans += a[fa[i]];
                clr[fa[i]] = 1;
            } else {
                ans += b[fa[i]];
                clr[fa[i]] = 2;
            }
        }
        if (ans < min) {
            min = ans;
            col = clr.clone();
        }
        ans = c[fa[0]] + b[fa[1]] + a[fa[2]];
        clr[fa[0]] = 3;
        clr[fa[1]] = 2;
        clr[fa[2]] = 1;
        for (int i = 3; i < n; i++) {
            if (i % 3 == 0) {
                ans += c[fa[i]];
                clr[fa[i]] = 3;
            } else if (i % 3 == 1) {
                ans += b[fa[i]];
                clr[fa[i]] = 2;
            } else {
                ans += a[fa[i]];
                clr[fa[i]] = 1;
            }
        }
        if (ans < min) {
            min = ans;
            col = clr.clone();
        }
        out.println(min);
        for (int i = 1; i <= n; i++) {
            out.print(col[i] + " ");
        }
        out.println();
    }
}