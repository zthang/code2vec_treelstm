public final int nextInt() {
    int c;
    for (c = this.read(); isSpaceChar(c); c = this.read()) {
    }
    byte sgn = 1;
    if (c == 45) {
        // 45 == '-'
        sgn = -1;
        c = this.read();
    }
    int res = 0;
    while (c >= 48 && c <= 57) {
        // 48 == '0', 57 == '9'
        res *= 10;
        // 48 == '0'
        res += c - 48;
        c = this.read();
        if (isSpaceChar(c)) {
            return res * sgn;
        }
    }
    throw new InputMismatchException();
}