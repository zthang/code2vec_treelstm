public void solve() {
    inputreader in = new inputreader();
    StringBuilder sb = new StringBuilder("");
    n = in.nextInt();
    dp1 = new int[n + 1];
    dp2 = new int[n + 1];
    arr = new int[n + 1];
    for (int i = 1; i <= n; i++) arr[i] = in.nextInt();
    arl = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) {
        arl.add(new ArrayList<Integer>());
    }
    int a, b;
    for (int i = 0; i < n - 1; i++) {
        a = in.nextInt();
        b = in.nextInt();
        arl.get(a).add(b);
        arl.get(b).add(a);
    }
    dfs1(1, 0);
    dfs2(1, 0);
    for (int i = 1; i <= n; i++) {
        System.out.print(dp2[i] + " ");
    }
}