void solve() {
    int n = ni(), k = ni();
    int[] a = new int[n + 1];
    int[] p = new int[n + 1];
    int[] rev = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        a[i] = ni();
        rev[a[i]] = i;
    }
    for (int i = 1; i <= n; i++) p[i] = ni();
    int[] idx = new int[n + 1];
    for (int i = 2; i <= n; i++) {
        idx[rev[p[i]]] = rev[p[i - 1]];
    }
    int[] ans = new int[n + 1];
    int R = 0, id = 0;
    for (int i = 1; i <= n; i++) {
        // pw.println(i+" "+idx[i]+" "+R+" "+id);
        if (R < i) {
            R = i;
            ++id;
            ans[i] = id;
        }
        while (R + 1 <= idx[i]) {
            R++;
            ans[R] = id;
        }
    }
    if (id < k)
        pw.println("NO");
    else {
        pw.println("YES");
        char[] s = new char[n];
        for (int i = 1; i <= n; i++) {
            s[a[i] - 1] = (char) ('a' + Math.min(26, ans[i]) - 1);
        }
        pw.println(new String(s));
    }
}