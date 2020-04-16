public String scanString() {
    int c = scan();
    if (c == -1)
        return null;
    while (isWhiteSpace(c)) c = scan();
    StringBuilder res = new StringBuilder();
    do {
        res.appendCodePoint(c);
        c = scan();
    } while (!isWhiteSpace(c));
    return res.toString();
}