public long nextLong() {
    int c = read();
    while (isSpace(c)) c = read();
    long res = 0, sign = 1;
    if (c == '-') {
        sign = -1;
        c = read();
    }
    do {
        if (c > '9' || c < '0')
            throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
    } while (!isSpace(c));
    return sign * res;
}