private static int firstTimeDfs(int idx) {
    int cnt = color[idx] == 1 ? 1 : -1;
    for (int v : tree[idx]) {
        int diff = firstTimeDfs(v);
        if (diff > 0) {
            cnt += diff;
        }
    }
    subTreeMaxDiff[idx] = cnt;
    return cnt;
}