public long nextLong() {
    if (!hN())
        throw new NoSuchElementException();
    long n = 0;
    boolean m = false;
    int b = rB();
    if (b == '-') {
        m = true;
        b = rB();
    }
    if (b < '0' || '9' < b) {
        throw new NumberFormatException();
    }
    while (true) {
        if ('0' <= b && b <= '9') {
            n *= 10;
            n += b - '0';
        } else if (b == -1 || !iPC(b)) {
            return (m ? -n : n);
        } else {
            throw new NumberFormatException();
        }
        b = rB();
    }
}