public void push(int v, int tl, int tr) {
    if (flag[v]) {
        if (v < pow) {
            flag[2 * v] = true;
            flag[2 * v + 1] = true;
            delta[2 * v] = delta[v];
            delta[2 * v + 1] = delta[v];
        }
        flag[v] = false;
        sum[v] = delta[v] * (tr - tl + 1);
    }
}