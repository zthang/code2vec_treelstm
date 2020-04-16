public int isBigger(ArrayList<Long> d, long i) {
    int ok = d.size();
    int ng = -1;
    while (Math.abs(ok - ng) > 1) {
        int mid = (ok + ng) / 2;
        if (d.get(mid) > i) {
            ok = mid;
        } else {
            ng = mid;
        }
    }
    return ok;
}