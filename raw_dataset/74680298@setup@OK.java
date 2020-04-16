static void setup(int me, int p) {
    lo[me] = curr;
    par[me] = p;
    for (int i : tree[me]) {
        if (i != p) {
            curr++;
            depth[i] = depth[me] + 1;
            setup(i, me);
        }
    }
    hi[me] = curr;
}