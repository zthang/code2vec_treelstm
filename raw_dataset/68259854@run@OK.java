void run() {
    int n = nextInt();
    List<Integer>[] g = new List[n];
    for (int i = 0; i < n; i++) {
        g[i] = new ArrayList<Integer>();
    }
    int[] c = new int[n];
    int p = -1;
    for (int v = 0; v < n; v++) {
        int u = nextInt() - 1;
        c[v] = nextInt();
        if (u < 0) {
            p = v;
        } else {
            g[u].add(v);
        }
    }
    List<Integer> list = solve(p, c, g);
    if (list == null) {
        println("NO");
    } else {
        println("YES");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[list.get(i)] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            print(a[i]);
            print(' ');
        }
    }
}