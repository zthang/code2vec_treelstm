void solve() {
    int n = ni();
    int[] par = new int[n];
    int[] c = new int[n];
    for (int i = 0; i < n; i++) {
        par[i] = ni() - 1;
        c[i] = ni();
    }
    int root = 0;
    for (int i = 0; i < n; i++) {
        if (par[i] == -1)
            root = i;
    }
    int[][] g = parentToG(par);
    int[][] pars = parents3(g, root);
    int[] ord = pars[1], dep = pars[2];
    int[] des = new int[n];
    Arrays.fill(des, 1);
    for (int i = n - 1; i >= 1; i--) {
        int cur = ord[i];
        des[par[cur]] += des[cur];
    }
    for (int i = 0; i < n; i++) {
        if (c[i] > des[i] - 1) {
            out.println("NO");
            return;
        }
    }
    out.println("YES");
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) nodes[i] = new Node(i);
    for (int i = n - 1; i >= 0; i--) {
        int cur = ord[i];
        Node roo = null;
        for (int e : g[cur]) {
            if (par[cur] == e)
                continue;
            roo = merge(roo, nodes[e]);
        }
        nodes[cur] = insert(roo, c[cur], nodes[cur]);
    }
    Node[] ns = nodes(nodes[root]);
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
        ans[ns[i].v] = i + 1;
    }
    for (int v : ans) {
        out.print(v + " ");
    }
    out.println();
}