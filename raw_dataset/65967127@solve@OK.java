void solve(int testNumber, FastScanner s, PrintWriter out) {
    N = s.nextInt();
    seen = new boolean[26];
    adj = new boolean[26][26];
    for (int i = 0; i < N; i++) {
        boolean[] a2z = new boolean[26];
        for (char c : s.next().toCharArray()) a2z[c - 'a'] |= true;
        for (int p = 0; p < 26; p++) if (a2z[p]) {
            seen[p] |= true;
            for (int q = 0; q < 26; q++) if (a2z[q])
                adj[p][q] |= true;
        }
    }
    DisjointSet DSU = new DisjointSet(26);
    for (int i = 0; i < 26; i++) {
        if (!seen[i])
            continue;
        let++;
        for (int j = 0; j < 26; j++) {
            if (!adj[i][j])
                continue;
            DSU.union(i, j);
        }
    }
    out.println(let - DSU.join);
}