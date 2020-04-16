public String readLine() throws IOException {
    byte[] buf = new byte[1000000];
    int cnt = 0, c;
    while ((c = read()) != -1) {
        if (c == '\n')
            break;
        buf[cnt++] = (byte) c;
    }
    return new String(buf, 0, cnt);
}