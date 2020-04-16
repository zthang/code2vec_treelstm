public long get(int x) {
    x = par(x);
    return sizee[x] * (sizee[x] - 1) / 2;
}