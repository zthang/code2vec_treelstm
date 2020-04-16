public int nextInt() throws IOException {
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
        if (isNum(buf[now]))
            ans = ans * 10 + buf[now] - '0';
        else
            throw new NumberFormatException();
        if (!move())
            break;
    }
    return (x ? -1 : 1) * ans;
}