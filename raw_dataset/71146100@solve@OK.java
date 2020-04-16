static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int t = ni();
    while (t-- > 0) {
        int n = ni();
        char[] c = ne().toCharArray();
        int[] indeg = new int[n];
        for (int i = 0; i < n - 1; ++i) {
            if (c[i] == '>') {
                indeg[i]++;
            } else {
                indeg[i + 1]++;
            }
        }
        int[][] ans = new int[2][n];
        int[] copy = new int[n];
        for (int i = 0; i < n; ++i) {
            copy[i] = indeg[i];
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                set.add(i);
            }
        }
        int ptr = 1;
        while (!set.isEmpty()) {
            int x = set.pollLast();
            ans[0][x] = ptr++;
            if (x > 0) {
                if (c[x - 1] == '>') {
                    indeg[x - 1]--;
                    if (indeg[x - 1] == 0) {
                        set.add((x - 1));
                    }
                }
            }
            if (x + 1 < n) {
                if (c[x] == '<') {
                    indeg[x + 1]--;
                    if (indeg[x + 1] == 0) {
                        set.add((x + 1));
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            indeg[i] = copy[i];
        }
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                set.add(i);
            }
        }
        ptr = 1;
        while (!set.isEmpty()) {
            int x = set.pollFirst();
            ans[1][x] = ptr++;
            if (x > 0) {
                if (c[x - 1] == '>') {
                    indeg[x - 1]--;
                    if (indeg[x - 1] == 0) {
                        set.add((x - 1));
                    }
                }
            }
            if (x + 1 < n) {
                if (c[x] == '<') {
                    indeg[x + 1]--;
                    if (indeg[x + 1] == 0) {
                        set.add((x + 1));
                    }
                }
            }
        }
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < n; ++j) {
                p(ans[i][j]);
            }
            pl();
        }
    }
    pw.flush();
    pw.close();
}