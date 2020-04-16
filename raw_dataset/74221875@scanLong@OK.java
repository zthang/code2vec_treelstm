public long scanLong() throws IOException {
    long ret = 0;
    long c = scan();
    while (c <= ' ') {
        c = scan();
    }
    boolean neg = (c == '-');
    if (neg) {
        c = scan();
    }
    do {
        ret = ret * 10 + c - '0';
    } while ((c = scan()) >= '0' && c <= '9');
    if (neg) {
        return -ret;
    }
    return ret;
}