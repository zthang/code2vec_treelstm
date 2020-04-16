public int getCost(int i) {
    i = find(i);
    if (fixed[i] == -1) {
        return Math.min(req[0][i], req[1][i]);
    }
    int d = delta(fixed[i], i);
    return req[d][i];
}