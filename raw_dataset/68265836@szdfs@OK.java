static void szdfs(int n) {
    sz[n] = 1;
    for (int ii : child[n]) {
        szdfs(ii);
        sz[n] += sz[ii];
    }
}