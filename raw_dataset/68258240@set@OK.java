public void set(int v, int tl, int tr, int l, int r, int x) {
    push(v, tl, tr);
    if (l > tr || r < tl) {
        return;
    }
    if (l <= tl && r >= tr) {
        delta[v] = x;
        flag[v] = true;
        push(v, tl, tr);
        return;
    }
    int tm = (tl + tr) / 2;
    set(2 * v, tl, tm, l, r, x);
    set(2 * v + 1, tm + 1, tr, l, r, x);
    sum[v] = f(sum[2 * v], sum[2 * v + 1]);
}