static ArrayList<Integer> dfs(int v) {
    ArrayList<Integer> res = new ArrayList<>();
    for (int u : adj[v]) {
        ArrayList<Integer> a = dfs(u);
        res.addAll(a);
    }
    if (c[v] > res.size()) {
        System.out.println("NO");
        System.exit(0);
    }
    res.add(c[v], v);
    return res;
}