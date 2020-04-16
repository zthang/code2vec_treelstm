private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt();
        color = in.nextIntArray(n);
        Set<Integer>[] g = new Set[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        // build tree using node 0 as root node
        tree = buildTree(g);
        subTreeMaxDiff = new int[n];
        res = new int[n];
        // first time dfs to compute each node's result when only considering each node as the root of each subtree and save results in subTreeMaxDiff
        // subTreeMaxDiff[0] is the final result for node 0 since we treat node 0 as the root of the entire tree
        firstTimeDfs(0);
        res[0] = subTreeMaxDiff[0];
        // second time dfs to compute the rest nodes' final results and save results in res.
        // for each node, update its children's results in the following way:
        // let's call v is a child node of parent node p, subTreeMaxDiff[v] has the all the contributions that are not from p.
        // compute p's contribution as res[p] - Math.max(subTreeMaxDiff[v], 0);
        // if p's contribution > 0, add it to subTreeMaxDiff[v] as the result for node v.
        secondTimeDfs(0);
        for (int i = 0; i < n; i++) {
            out.print(res[i] + " ");
        }
    }
    out.close();
}