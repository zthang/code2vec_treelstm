public int isSmaller(ArrayList<Long> d, long i) {
    int ok = -1;
    int ng = d.size();
    while (Math.abs(ok - ng) > 1) {
        int mid = (ok + ng) / 2;
        if (d.get(mid) < i) {
            ok = mid;
        } else {
            ng = mid;
        }
    }
    return ok;
}