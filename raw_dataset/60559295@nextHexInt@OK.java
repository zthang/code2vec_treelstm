public int nextHexInt() throws IOException {
    if (!hasNext())
        throw new NullPointerException();
    boolean x = false;
    if (buf[now] == '-') {
        x = true;
        if (!move())
            throw new NumberFormatException();
    }
    int ans = 0;
    while (!isSpaceChar(buf[now])) {
        if (isHex(buf[now]))
            ans = ans * 16 + toHex(buf[now]);
        else
            throw new NumberFormatException();
        if (!move())
            break;
    }
    return (x ? -1 : 1) * ans;
}