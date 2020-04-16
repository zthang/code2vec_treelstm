public long nextLong() {
    int c;
    for (c = this.read(); isSpaceChar(c); c = this.read()) {
        ;
    }
    byte sgn = 1;
    if (c == 45) {
        sgn = -1;
        c = this.read();
    }
    long res = 0L;
    while (c >= 48 && c <= 57) {
        res *= 10L;
        res += (long) (c - 48);
        c = this.read();
        if (isSpaceChar(c)) {
            return res * (long) sgn;
        }
    }
    throw new InputMismatchException();
}