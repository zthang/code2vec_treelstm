public void run() throws Exception {
    int n = file.nextInt();
    color = new int[n];
    ans = new int[n];
    dp = new int[n];
    adj = new ArrayList<ArrayList<Integer>>(n);
    for (int i = 0; i < n; i++) {
        color[i] = file.nextInt() == 0 ? -1 : 1;
        adj.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < n - 1; i++) {
        int u = file.nextInt() - 1;
        int v = file.nextInt() - 1;
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    dfs1(0, -1);
    dfs2(0, -1);
    for (int i = 0; i < n; i++) {
        if (i > 0)
            print(" ");
        print(ans[i]);
    }
    println("");
    file.out.flush();
    file.out.close();
}