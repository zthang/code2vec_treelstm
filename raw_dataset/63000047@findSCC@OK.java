public void findSCC() {
    Arrays.fill(vis, -1);
    Arrays.fill(onStack, false);
    sp = 0;
    globalTime = 0;
    numComps = 0;
    for (int i = 0; i < n; i++) {
        if (vis[i] < 0) {
            dfsTarjan(i);
        }
    }
}