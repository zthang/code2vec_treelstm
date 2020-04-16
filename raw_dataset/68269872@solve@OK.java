static void solve() throws IOException {
    n = nextInt();
    list = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) list.add(new ArrayList<Integer>());
    c = new int[n + 1];
    a = new int[n + 1];
    clist = new ArrayList<Integer>();
    for (int i = 1; i <= n; i++) clist.add(i);
    int root = 0;
    for (int i = 1; i <= n; i++) {
        int p = nextInt();
        if (p == 0)
            root = i;
        else
            list.get(p).add(i);
        c[i] = nextInt();
    }
    subcount = new int[n + 1];
    dfs1(root);
    // debug(subcount);
    if (dfs(root)) {
        out.println("YES");
        for (int i = 1; i <= n; i++) out.print(a[i] + " ");
    } else
        out.println("NO");
}