public void solve(int testNumber, InputReader sc, PrintWriter out) throws IOException {
    int n = sc.nextInt();
    int m = sc.nextInt();
    HashSet<Integer>[] edge = new HashSet[n + 1];
    for (int i = 0; i <= n; i++) edge[i] = new HashSet<Integer>();
    for (int i = 0; i < m; i++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        edge[x].add(y);
        edge[y].add(x);
    }
    HashSet<Integer>[] set = new HashSet[3];
    for (int i = 0; i < 3; i++) set[i] = new HashSet<Integer>();
    int[] color = new int[n + 1];
    Arrays.fill(color, -2);
    color[1] = 1;
    set[1].add(1);
    for (int v : edge[1]) color[v] = -1;
    for (int i = 1; i <= n; i++) {
        if (color[i] == -1) {
            color[i] = 0;
            for (int v : edge[i]) if (color[v] == -1)
                color[v] = 2;
            for (int j = 1; j <= n; j++) {
                if (color[i] == -1)
                    color[i] = 0;
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        if (color[i] == -2)
            color[i] = 1;
    }
    for (int i = 1; i <= n; i++) {
        if (color[i] >= 0 && color[i] <= 2) {
            set[color[i]].add(i);
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int v : edge[i]) {
            if (color[i] == color[v]) {
                out.println("-1");
                return;
            }
        }
    }
    for (int i = 0; i < 3; i++) {
        if (set[i].size() == 0) {
            out.println("-1");
            return;
        }
    }
    if (1l * set[0].size() * set[1].size() + 1l * set[0].size() * set[2].size() + 1l * set[1].size() * set[2].size() != m) {
        out.println("-1");
        return;
    }
    for (int i = 1; i <= n; i++) {
        if (set[0].contains(i))
            out.print("1 ");
        else if (set[1].contains(i))
            out.print("2 ");
        else if (set[2].contains(i))
            out.print("3 ");
    }
    out.println();
}