public int nextInt() throws Exception {
    int ret = 0;
    byte c = read();
    while (c <= ' ') {
        c = read();
    }
    do {
        ret = ret * 10 + c - '0';
        c = read();
    } while (c > ' ');
    return ret;
}