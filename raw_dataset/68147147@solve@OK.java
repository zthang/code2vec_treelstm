void solve() {
    int t = ni();
    Set<Pair> st = new HashSet<>();
    Map<Tuple, Integer> st1 = new HashMap<>();
    for (int i = 0; i < t; ++i) {
        int n = ni();
        st.clear();
        st1.clear();
        for (int j = 0; j < n - 2; ++j) {
            int[] a = na(3);
            st1.put(new Tuple(a), j + 1);
            for (int k = 0; k <= 2; ++k) {
                Pair r = new Pair(a[k], a[(k + 1) % 3]);
                if (st.contains(r)) {
                    st.remove(r);
                } else {
                    st.add(r);
                }
            }
        }
        int[][] vl = new int[n + 1][2];
        int f = 0;
        int s = 0;
        for (Pair v : st) {
            int n1 = v.x;
            int n2 = v.y;
            if (f == 0) {
                f = n1;
                s = n2;
            }
            if (vl[n1][0] == 0) {
                vl[n1][0] = n2;
            } else {
                vl[n1][1] = n2;
            }
            if (vl[n2][0] == 0) {
                vl[n2][0] = n1;
            } else {
                vl[n2][1] = n1;
            }
        }
        print(f + " " + s + " ");
        int[] d = new int[n];
        d[0] = f;
        d[1] = s;
        int ne = 2;
        for (int j = 0; j < n - 2; ++j) {
            for (int u = 0; u < 2; ++u) {
                int g = vl[s][u];
                if (g != f) {
                    f = s;
                    s = g;
                    d[ne++] = g;
                    print(g);
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
                g = ri;
                if (st1.containsKey(tp)) {
                    int id = st1.get(tp);
                    print(id);
                    if (j != n - 2) {
                        print(" ");
                    }
                    right[le] = ri;
                    left[ri] = le;
                    break;
                }
            }
        }
        println();
    }
}