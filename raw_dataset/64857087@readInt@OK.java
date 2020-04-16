public final int readInt() throws IOException {
    int c = read();
    boolean neg = false;
    while (isSpaceChar(c)) {
        c = read();
    }
    char d = (char) c;
    // log("d:"+d);
    if (d == '-') {
        neg = true;
        c = read();
    }
    int res = 0;
    do {
        res *= 10;
        res += c - '0';
        c = read();
    } while (!isSpaceChar(c));
    // log("res:"+res);
    if (neg)
        return -res;
    return res;
}