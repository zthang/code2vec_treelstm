static void solve() {
    n = in.nextInt();
    p = new int[n];
    c = new int[n];
    g = new ArrayList[n];
    Arrays.setAll(g, i -> new ArrayList<>());
    int root = 0;
    for (int i = 0; i < n; i++) {
        p[i] = in.nextInt();
        c[i] = in.nextInt();
        if (p[i] == 0) {
            root = i;
        } else {
            g[p[i] - 1].add(i);
        }
    }
    size = new int[n];
    dfs1(root);
    for (int i = 0; i < n; i++) {
        if (c[i] > size[i] - 1) {
            out.println("NO");
            return;
        }
    }
    int[] arr = new int[n];
    Arrays.fill(arr, 1);
    st = new SegmentTree(arr);
    ans = new int[n];
    dfs2(root);
    out.println("YES");
    for (int a : ans) {
        out.print(a);
        out.print(' ');
    }
    out.println();
}