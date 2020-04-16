public void solve(int testNumber, LightScanner in, LightWriter out) {
    // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
    int n = in.ints();
    IntUnionFind uf = new IntUnionFind(26);
    String[] s = in.string(n);
    for (int i = 0; i < n; i++) {
        for (int j = 1; j < s[i].length(); j++) {
            uf.union(s[i].charAt(j - 1) - 'a', s[i].charAt(j) - 'a');
        }
    }
    Set<Integer> size = new HashSet<>();
    for (int i = 0; i < n; i++) size.add(uf.find(s[i].charAt(0) - 'a'));
    out.ans(size.size()).ln();
}