public void solve(FastScanner br, PrintWriter pw) throws IOException {
    int n = br.ni();
    boolean[][] in = new boolean[n][26];
    for (int i = 0; i < n; i++) {
        String s = br.nt();
        for (int j = 0; j < s.length(); j++) {
            in[i][(int) s.charAt(j) - 97] = true;
        }
    }
    Dsu d = new Dsu(n);
    d.createSet();
    for (int i = 0; i < 26; i++) {
        int first = -1;
        for (int j = 0; j < n; j++) {
            if (in[j][i] == true && first == -1) {
                first = j;
            } else {
                if (in[j][i]) {
                    d.mergeSet(first, j);
                }
            }
        }
    }
    HashSet<Integer> h = new HashSet<>();
    for (int i = 0; i < n; i++) {
        h.add(d.findParent(i));
    }
    pw.println(h.size());
}