// ----------------------------------------------------------------------------------------------------//
void solve() {
    int mod = (int) 1e9 + 7;
    int n = ni();
    Dsu uf = new Dsu(26 + n);
    String[] s = new String[n];
    for (int i = 0; i < n; i++) {
        s[i] = ns();
    }
    for (int j = 0; j < n; j++) {
        for (int k = 0; k < s[j].length(); k++) {
            uf.union(s[j].charAt(k) - 'a', j + 26);
        }
    }
    int x = 0;
    Set<Integer> r = uf.getRoots();
    for (int i : r) {
        if (uf.size[i] == 1)
            x++;
    }
    out.println(uf.count() - x);
}