void findPath(int mask, boolean[] hasCycle, ArrayList<boxPair>[] maskPath) {
    if (hasCycle[mask]) {
        for (boxPair b : maskPath[mask]) {
            ans[get(b.addTo)] = b;
        }
        return;
    }
    for (int i = mask & (mask - 1); i > 0; i = mask & (i - 1)) {
        if (rec(i, hasCycle) && rec(i ^ mask, hasCycle)) {
            findPath(i, hasCycle, maskPath);
            findPath(i ^ mask, hasCycle, maskPath);
            return;
        }
    }
}