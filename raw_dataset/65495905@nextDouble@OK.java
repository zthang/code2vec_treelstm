public double nextDouble() {
    long c = read();
    while (isSpaceChar(c)) {
        c = read();
    }
    double sgn = 1;
    if (c == '-') {
        sgn = -1;
        c = read();
    }
    double res = 0;
    do {
        if (c < '0' || c > '9') {
            throw new InputMismatchException();
        }
        res *= 10;
        res += c - '0';
        c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
}