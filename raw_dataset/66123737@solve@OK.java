public void solve() {
    DisjointSet dsu = new DisjointSet(26);
    int n = in.ni();
    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
        words[i] = in.next();
        int m = words[i].length();
        int u = words[i].charAt(0) - 'a';
        for (int j = 1; j < m; j++) {
            int v = words[i].charAt(j) - 'a';
            dsu.join(u, v);
        }
    }
    Set<Integer> roots = new HashSet<>();
    for (int i = 0; i < n; i++) {
        roots.add(dsu.root(words[i].charAt(0) - 'a'));
    }
    out.println(roots.size());
}