int getNode(int myHieght, int parent, int digit) {
    int ret = nodes++;
    curH[ret] = myHieght;
    hash[ret] = (int) ((hash[parent] * 10L + digit) % mod);
    prev[ret] = digit;
    for (int i = 0; i < 10; i++) {
        next[i][ret] = -1;
    }
    up[0][ret] = parent;
    for (int i = 1; i < up.length; i++) {
        up[i][ret] = up[i - 1][up[i - 1][ret]];
    }
    return ret;
}