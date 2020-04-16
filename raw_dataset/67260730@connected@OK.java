boolean connected(int p, int q) {
    int pr = findRoot(p);
    int qr = findRoot(q);
    return pr == qr;
}