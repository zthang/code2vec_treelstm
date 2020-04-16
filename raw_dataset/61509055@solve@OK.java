public void solve(int testNumber, LightScanner in, LightWriter out) {
    // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
    int n = in.ints(), m = in.ints();
    int[] x = new int[m], y = new int[m];
    for (int i = 0; i < m; i++) {
        x[i] = in.ints() - 1;
        y[i] = in.ints() - 1;
    }
    BitSet[] notme = new BitSet[n];
    notme[0] = new BitSet(n);
    int piv = -1;
    for (int i = 0; i < m; i++) {
        if (x[i] == 0) {
            notme[0].set(y[i]);
            if (piv == -1)
                piv = y[i];
        }
    }
    for (int i = 1; i < n; i++) {
        if (!notme[0].get(i))
            notme[i] = notme[0];
    }
    if (piv == -1) {
        out.ans(-1).ln();
        return;
    }
    notme[piv] = new BitSet();
    for (int i = 0; i < m; i++) {
        if (x[i] == piv) {
            notme[piv].set(y[i]);
        } else if (y[i] == piv) {
            notme[piv].set(x[i]);
        }
    }
    for (int i = 0; i < n; i++) {
        if (!notme[piv].get(i))
            notme[i] = notme[piv];
    }
    BitSet rem = (BitSet) notme[0].clone();
    rem.and(notme[piv]);
    if (rem.cardinality() == 0) {
        out.ans(-1).ln();
        return;
    }
    notme[0].flip(0, n);
    notme[piv].flip(0, n);
    int[] ans = new int[n];
    long c1 = notme[0].cardinality(), c2 = notme[piv].cardinality(), c3 = n - c1 - c2;
    long mexp = c1 * c2 + c2 * c3 + c3 * c1;
    if (m != mexp) {
        out.ans(-1).ln();
        return;
    }
    for (int i = 0; i < n; i++) {
        if (notme[i] == notme[0])
            ans[i] = 1;
        else if (notme[i] == notme[piv])
            ans[i] = 2;
        else
            ans[i] = 3;
    }
    for (int i = 0; i < m; i++) {
        if (ans[x[i]] == ans[y[i]]) {
            out.ans(-1).ln();
            return;
        }
    }
    out.ans(ans).ln();
}