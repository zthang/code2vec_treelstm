void solve() {
    int n = ni();
    int[][] ps = new int[n][3];
    for (int i = 0; i < n; ++i) {
        ps[i][0] = ni();
        ps[i][1] = ni();
        ps[i][2] = i;
    }
    Arrays.sort(ps, (x, y) -> {
        return Integer.compare(x[0], y[0]);
    });
    init(n);
    TreeSet<int[]> st = new TreeSet<>((x, y) -> {
        return Integer.compare(x[0], y[0]);
    });
    int cnt = 0;
    for (int i = 0; i < n; ++i) {
        int r = ps[i][1];
        int[] fk = new int[] { ps[i][0], ps[i][2] };
        Set<int[]> tl = st.tailSet(fk);
        for (int[] it : tl) {
            if (it[0] > r)
                break;
            cnt++;
            combine(it[1], ps[i][2]);
            if (cnt >= n) {
                println("NO");
                return;
            }
        }
        st.add(new int[] { r, ps[i][2] });
    }
    if (cnt >= n || groups != 1) {
        println("NO");
    } else {
        println("YES");
    }
}