public String readLine() throws IOException {
    // line length
    byte[] buf = new byte[500005];
    int cnt = 0, c;
    while ((c = read()) != -1) {
        if (c == '\n')
            break;
        buf[cnt++] = (byte) c;
    }
    return new String(buf, 0, cnt);
}