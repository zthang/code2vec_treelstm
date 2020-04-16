public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    arrayList = new ArrayList[n + 1];
    c = new int[n + 1];
    root = -1;
    ans = true;
    for (int i = 0; i <= n; i++) arrayList[i] = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        int p = in.scanInt();
        c[i] = in.scanInt();
        if (p == 0) {
            root = i;
        } else {
            arrayList[p].add(i);
        }
    }
    int[] order = dfs(root);
    if (!ans) {
        out.println("NO");
        return;
    }
    int[] res = new int[n + 1];
    for (int i = 0; i < order.length; i++) res[order[i]] = i + 1;
    out.println("YES");
    for (int i = 1; i <= n; i++) out.print(res[i] + " ");
}