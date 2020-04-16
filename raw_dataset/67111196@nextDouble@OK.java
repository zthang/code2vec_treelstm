public double nextDouble() {
    double ret = 0, div = 1;
    byte c = (byte) read();
    while (c <= ' ') c = (byte) read();
    boolean neg = (c == '-');
    if (neg)
        c = (byte) read();
    do {
        ret = ret * 10 + c - '0';
    } while ((c = (byte) read()) >= '0' && c <= '9');
    if (c == '.')
        while ((c = (byte) read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
    if (neg)
        return -ret;
    return ret;
}