public int sametime(int x, int y) {
    if (find(now, x) != find(now, y))
        return -1;
    int ok = now;
    int ng = 0;
    while (ok - ng > 1) {
        int mid = (ok + ng) / 2;
        if (find(mid, x) == find(mid, y)) {
            ok = mid;
        } else {
            ng = mid;
        }
    }
    return ok;
}