public long nextLong() {
    int c = read();
    while (isSpaceChar(c)) c = read();
    int sign = 1;
    if (c == '-') {
        sign = -1;
        c = read();
    }
    long result = 0;
    do {
        if (c < '0' || c > '9')
            throw new InputMismatchException();
        result *= 10;
        result += c & 15;
        c = read();
    } while (!isSpaceChar(c));
    return result * sign;
}