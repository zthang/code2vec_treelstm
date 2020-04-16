static void solve(ArrayList<Integer> ids) {
    int col = c[ids.get(0)];
    boolean allSame = true;
    for (int i = 1; i < ids.size(); i++) allSame &= (c[ids.get(i)] == col);
    if (allSame) {
        res = Math.min(res, 1);
        return;
    }
    res = Math.min(res, ids.size());
    for (int v = 2; v < ids.size(); v++) {
        if (ids.size() % v == 0)
            if (go(ids, v))
                res = Math.min(res, v);
    }
}