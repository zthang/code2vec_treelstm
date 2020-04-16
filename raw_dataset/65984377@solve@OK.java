void solve() {
    int n = ni();
    String[] x = new String[n];
    for (int i = 0; i < n; i++) {
        x[i] = ns();
    }
    HashSet<Integer>[] hs = new HashSet[26];
    for (int i = 0; i < 26; i++) hs[i] = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
        char[] ch = x[i].toCharArray();
        for (char j : ch) {
            if (!hs[j - 'a'].contains(i))
                hs[j - 'a'].add(i);
        }
    }
    for (int i = 0; i < 26; i++) {
        if (hs[i].size() != 0) {
            for (int j = 0; j < 26; j++) {
                if (hs[j].size() != 0 && j != i) {
                    for (int k : hs[i]) {
                        if (hs[j].contains(k)) {
                            // out.println(hs[i]);
                            // out.println(hs[j]);
                            hs[i].addAll(hs[j]);
                            hs[j] = new HashSet<Integer>();
                            // out.println(hs[i]);
                            break;
                        }
                    }
                }
            }
        }
    }
    int ct = 0;
    for (int i = 0; i < 26; i++) {
        // out.println(hs[i]);
        if (hs[i].size() != 0) {
            ct++;
        }
    }
    out.println(ct);
}