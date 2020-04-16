void solve() throws IOException {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = in.nextInt(), m = in.nextInt();
    int[] a = new int[m], b = new int[m];
    for (int i = 0; i < m; i++) {
        a[i] = in.nextInt() - 1;
        b[i] = in.nextInt() - 1;
    }
    if (n < 7) {
        System.out.println(m);
    } else {
        int max = 0;
        HashSet<Pair> e = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    for (int l = 0; l < 6; l++) {
                        for (int o = 0; o < 6; o++) {
                            for (int p = 0; p < 6; p++) {
                                for (int q = 0; q < 6; q++) {
                                    int[] num = new int[] { i, j, k, l, o, p, q };
                                    for (int r = 0; r < m; r++) {
                                        e.add(new Pair(num[a[r]], num[b[r]]));
                                    }
                                    if (max < e.size()) {
                                        max = max(max, e.size());
                                    }
                                    e.clear();
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}