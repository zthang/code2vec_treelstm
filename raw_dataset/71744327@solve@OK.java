void solve() {
    int n = ni(), m = ni(), k = ni();
    int max = 4 * n * m - 2 * n - 2 * m;
    if (k > max) {
        out.println("NO");
        return;
    }
    out.println("YES");
    a = new ArrayList<>();
    if (m > 1)
        play(n, m, k);
    else {
        int x = n - 1;
        if (k >= x) {
            a.add(new pair(x, "D"));
            k -= x;
        } else if (k > 0) {
            a.add(new pair(k, "D"));
        }
        if (k >= x) {
            a.add(new pair(x, "U"));
            k -= x;
        } else if (k > 0) {
            a.add(new pair(k, "U"));
        }
    }
    out.println(a.size());
    for (pair p : a) out.println(p.U + " " + p.V);
}