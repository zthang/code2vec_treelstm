public int next(char[] s) throws IOException {
    if (!hasNext())
        throw new NullPointerException();
    int len = 0;
    while (!isSpaceChar(buf[now]) && len < s.length) {
        s[len++] = buf[now];
        if (!move())
            break;
    }
    return len;
}