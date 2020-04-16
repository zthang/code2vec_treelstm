public void reset() {
    for (int i = 0; i < p.length; i++) {
        p[i] = i;
        rank[i] = 0;
        delta[i] = 0;
        fixed[i] = -1;
        req[0][i] = req[1][i] = 0;
    }
}