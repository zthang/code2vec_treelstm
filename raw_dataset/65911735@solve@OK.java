// static int seg[];
static void solve() throws IOException {
    Reader sc = new Reader();
    int n, m, i, tx, y;
    ans = 0;
    n = sc.nextInt();
    m = sc.nextInt();
    a = new int[n + 1];
    co = new ArrayList<>();
    adj = new ArrayList<>();
    sb = new StringBuilder();
    for (i = 0; i <= n; i++) {
        adj.add(new ArrayList<>());
    }
    for (i = 0; i < m; i++) {
        tx = sc.nextInt();
        y = sc.nextInt();
        adj.get(tx).add(y);
        adj.get(y).add(tx);
    }
    tr(1, n);
    int[][] x = new int[7][7];
    int k = 0;
    int l = 0;
    for (i = 0; i < co.size(); i++) {
        k = 0;
        if (co.get(i).length() < n)
            continue;
        for (int j = 0; j < co.get(i).length(); j++) {
            a[j + 1] = co.get(i).charAt(j) - '0';
        }
        for (int j = 1; j <= n; j++) {
            for (int u = 0; u < adj.get(j).size(); u++) {
                l = adj.get(j).get(u);
                if (x[a[j]][a[l]] == 0 && x[a[j]][a[l]] == 0) {
                    ++k;
                    x[a[j]][a[l]] = 1;
                    x[a[l]][a[j]] = 1;
                }
            }
        }
        ans = Math.max(ans, k);
        for (int j = 1; j <= 6; j++) {
            for (int u = 1; u <= 6; u++) {
                x[j][u] = 0;
            }
        }
    }
    System.out.println(ans);
}