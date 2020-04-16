public double nextDouble() {
    int c = snext();
    while (isSpaceChar(c)) {
        c = snext();
    }
    int sgn = 1;
    if (c == '-') {
        sgn = -1;
        c = snext();
    }
    double res = 0;
    while (c <= '9' && c >= '0') {
        res *= 10;
        res += c - '0';
        c = snext();
    }
    if (c == '.') {
        double decimal = 0;
        long multiplier = 1;
        c = snext();
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            decimal *= 10;
            decimal += c - '0';
            multiplier *= 10;
            c = snext();
        } while (!isSpaceChar(c));
        return sgn * (res + decimal / multiplier);
    } else {
        if (!isSpaceChar(c)) {
            throw new InputMismatchException();
        }
        return sgn * res;
    }
}