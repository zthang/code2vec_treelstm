public String nextLine() throws IOException {
    if (lineBuf == null)
        lineBuf = new byte[MAX_LINE_SIZE];
    int ctr = 0;
    byte c;
    while ((c = read()) != -1) {
        if (c == '\r')
            continue;
        if (c == '\n')
            break;
        lineBuf[ctr++] = c;
    }
    return new String(lineBuf, 0, ctr);
}