int query(int k, int l, int r) {
    Segment trace = this;
    while (l < r) {
        int mid = (l + r) / 2;
        if (trace.left.size > k) {
            trace = trace.left;
            r = mid;
        } else {
            k -= trace.left.size;
            trace = trace.right;
            l = mid + 1;
        }
    }
    return l;
}