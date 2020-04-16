public String next() throws IOException {
    if (lineBuf == null)
        lineBuf = new byte[MAX_LINE_SIZE];
    int ctr = 0;
    byte c = read();
    while (c <= ' ') c = read();
    while (c > ' ') {
        lineBuf[ctr++] = c;
        c = read();
    }
    return new String(lineBuf, 0, ctr);
}