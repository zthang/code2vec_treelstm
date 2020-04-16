public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    for (int i = 1; i <= n; i++) {
        a[i] = new Vector<>();
    }
    pair<Integer, Integer, Integer>[] ans = new pair[m];
    for (int i = 0; i < m; i++) {
        int x, y;
        x = in.nextInt();
        y = in.nextInt();
        ans[i] = new pair(x, y, i);
        a[x].add(y);
    }
    boolean flag = cycle(n);
    // out.println(flag);
    int[] res = new int[m];
    Arrays.fill(res, 1);
    if (flag == false) {
        out.println(1);
        for (int i : res) {
            out.print(i + " ");
        }
        return;
    }
    for (int i = 0; i < m; i++) {
        if (ans[i].getFi() > ans[i].getSe()) {
            res[ans[i].getTh()] = 2;
        }
    }
    out.println(2);
    for (int i : res) {
        out.print(i + " ");
    }
}