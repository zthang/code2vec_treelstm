static boolean ok(long x, long[] s, long[] t, long[] u) {
    for (int i = 0; i < s.length - 1; i++) {
        int idx = lower_bound(s, 0, s.length - 1, x - t[i]);
        if (idx == s.length)
            continue;
        idx = Math.max(idx, i + 1);
        if (s[i] + u[idx] + 1 >= x) {
            return true;
        }
    }
    return false;
}