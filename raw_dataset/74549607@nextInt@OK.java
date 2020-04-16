public int nextInt() {
    int c = read();
    while (isSpace(c)) c = read();
    int res = 0, sign = 1;
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