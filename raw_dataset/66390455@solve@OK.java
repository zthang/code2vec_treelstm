void solve() throws IOException {
    PrintWriter out = new PrintWriter(System.out);
    StringBuilder sb = new StringBuilder("");
    int n = ni();
    char[][] s = new char[n][];
    for (int i = 0; i < n; i++) s[i] = ns().toCharArray();
    HashSet<Character>[] h = new HashSet[30];
    for (int i = 0; i < 30; i++) h[i] = new HashSet<>();
    int id = 0;
    for (int i = 0; i < n; i++) {
        int[] tm = new int[30];
        int idd = 0;
        o: for (int j = 0; j < id; j++) {
            if (h[j] == null)
                continue;
            for (char c : s[i]) {
                if (h[j].contains(c)) {
                    tm[idd++] = j;
                    continue o;
                }
            }
        }
        if (idd == 0) {
            for (char c : s[i]) h[id].add(c);
            id++;
            continue;
        }
        for (char c : s[i]) h[tm[0]].add(c);
        for (int j = 1; j < idd; j++) {
            for (char c : h[tm[j]]) h[tm[0]].add(c);
            h[tm[j]] = null;
        }
    }
    int ans = 0;
    for (int i = 0; i < id; i++) {
        if (h[i] != null)
            ans++;
    }
    System.out.println(ans);
}