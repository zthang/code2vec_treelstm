public int[] merge(int[] d, int st, int e) {
    if (st > e)
        return null;
    if (e == st) {
        int[] ans = { d[e] };
        return ans;
    }
    int mid = (st + e) / 2;
    int[] ans = new int[e - st + 1];
    int[] ll = merge(d, st, mid);
    int[] rr = merge(d, mid + 1, e);
    if (ll == null)
        return rr;
    if (rr == null)
        return ll;
    int iver = 0;
    int idxl = 0;
    int idxr = 0;
    for (int i = st; i <= e; i++) {
        if (ll[idxl] < rr[idxr]) {
        }
    }
    return ans;
}