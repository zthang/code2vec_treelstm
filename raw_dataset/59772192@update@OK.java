public void update(int v, int vl, int vr, int pos) {
    if (vl == vr) {
        t[v] = 1;
        return;
    }
    int tmp = (vl + vr) / 2;
    if (pos <= tmp) {
        update(2 * v, vl, tmp, pos);
    } else
        update(2 * v + 1, tmp + 1, vr, pos);
    t[v] = t[2 * v] + t[2 * v + 1];
}