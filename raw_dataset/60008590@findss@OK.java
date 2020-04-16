int findss(int v, int tl, int tr, long sum) {
    if (sum > t[v])
        return -1;
    if (tl == tr)
        return tl;
    int tm = (tl + tr) / 2;
    if (t[v * 2] > sum) {
        return findss(v * 2, tl, tm, sum);
    } else {
        return findss(v * 2 + 1, tm + 1, tr, sum - t[v * 2]);
    }
}