public static int anc(int x, int y) {
    int ret = x;
    for (int i = 0; i < 18; i++) {
        if ((y & (1 << i)) == 0) {
            continue;
        }
        ret = par[ret][i];
    }
    return ret;
}