void solve() {
    int t = ni();
    for (int i = 0; i < t; ++i) {
        int n = ni();
        int[][] a = new int[n - 2][];
        Set<Pair> st = new HashSet<>();
        Map<Tuple, Integer> st1 = new HashMap<>();
        for (int j = 0; j < n - 2; ++j) {
            a[j] = na(3);
            st1.put(new Tuple(a[j]), j + 1);
            for (int k = 0; k <= 2; ++k) {
                Pair r = new Pair(a[j][k], a[j][(k + 1) % 3]);
                if (st.contains(r)) {
                    st.remove(r);
                } else {
                    st.add(r);
                }
            }
        }
        Set<Integer>[] vl = new Set[n + 1];
        for (int j = 1; j <= n; ++j) {
            vl[j] = new HashSet<>();
        }
        int f = 0;
        int s = 0;
        for (Pair v : st) {
            int n1 = v.x;
            int n2 = v.y;
            if (f == 0) {
                f = n1;
                s = n2;
            }
            vl[n1].add(n2);
            vl[n2].add(n1);
        }
        print(f + " " + s + " ");
        int[] d = new int[n];
        d[0] = f;
        d[1] = s;
        int ne = 2;
        for (int j = 0; j < n - 2; ++j) {
            for (int u : vl[s]) {
                if (u != f) {
                    f = s;
                    s = u;
                    d[ne++] = u;
                    print(u);
                    break;
                }
            }
            if (j != n - 3) {
                print(" ");
            }
        }
        println();
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int j = 0; j < n; ++j) {
            int pre = (j - 1 + n) % n;
            int nex = (j + 1) % n;
            left[d[j]] = d[pre];
            right[d[j]] = d[nex];
        }
        int g = 1;
        for (int j = 0; j < n - 2; ++j) {
            while (true) {
                int le = left[g];
                int ri = right[g];
                Tuple tp = new Tuple(new int[] { le, g, ri });
                if (st1.containsKey(tp)) {
                    int id = st1.get(tp);
                    print(id);
                    if (j != n - 2) {
                        print(" ");
                    }
                    right[le] = ri;
                    left[ri] = le;
                    g = ri;
                    break;
                } else {
                    g = ri;
                }
            }
        }
        println();
    }
}