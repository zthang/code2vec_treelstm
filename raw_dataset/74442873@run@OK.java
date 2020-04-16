public void run() {
    sc = new InputReader(System.in);
    // Scanner sc=new Scanner(System.in);
    // Random sc=new Random();
    out = new PrintWriter(System.out);
    n = sc.nextInt();
    int q = sc.nextInt();
    l = new ArrayList[n];
    hs = new HashSet[n];
    for (int i = 0; i < n; i++) {
        l[i] = new ArrayList<>();
        hs[i] = new HashSet<>();
    }
    for (int i = 0; i < n - 1; i++) {
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        l[u].add(v);
        l[v].add(u);
        hs[u].add(v);
        hs[v].add(u);
    }
    LCA lca = new LCA(n, l);
    lca.build(0);
    while (q-- > 0) {
        int m = sc.nextInt();
        int[][] a = new int[m][2];
        for (int i = 0; i < m; i++) {
            a[i][0] = sc.nextInt() - 1;
            a[i][1] = lca.lvl[a[i][0]];
        }
        Arrays.sort(a, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });
        // for (int i = 0; i <m ; i++) {
        // out.println(a[i][0]+" "+a[i][1]);
        // }
        int lastNode = a[0][0];
        int flag = 0;
        for (int i = 1; i < a.length; i++) {
            int dis = lca.lvl[lastNode] - lca.lvl[a[i][0]];
            if (dis == 0) {
                if (lca.par[lastNode][0] == -1) {
                    flag = 1;
                    break;
                } else {
                    if (!hs[lca.par[lastNode][0]].contains(a[i][0])) {
                        flag = 1;
                        break;
                    }
                }
            }
            int u = lastNode;
            while (dis > 0) {
                int raise = lca.log2(dis);
                u = lca.par[u][raise];
                dis ^= 1 << raise;
            }
            // out.println(u+" yes "+a[i][0]);
            if (u != a[i][0]) {
                if (lca.par[u][0] == -1) {
                    flag = 1;
                    break;
                } else {
                    if (!hs[lca.par[u][0]].contains(a[i][0])) {
                        flag = 1;
                        break;
                    }
                }
            }
        }
        if (flag == 0) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
    out.close();
}