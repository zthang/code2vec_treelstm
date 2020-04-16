private int join(int[] p, int[] min, int[] max, int x, int y) {
    int rx = find(p, x);
    int ry = find(p, y);
    if (rx == ry) {
        return 0;
    }
    int mn = Math.min(min[rx], min[ry]);
    int mx = Math.max(max[rx], max[ry]);
    p[rx] = ry;
    min[ry] = mn;
    max[ry] = mx;
    return 1;
}