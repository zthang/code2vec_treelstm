private void solve(InputReader inp, PrintWriter out) {
    int n = inp.nextInt(), k = inp.nextInt();
    DSU dsu = new DSU(n);
    for (int i = 0; i < k; i++) dsu.union(inp.nextInt() - 1, inp.nextInt() - 1);
    HashSet<Integer> parents = new HashSet<>();
    for (int i = 0; i < n; i++) parents.add(dsu.get(i));
    out.println(k - n + parents.size());
}