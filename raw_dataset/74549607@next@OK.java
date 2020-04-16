public String next() {
    StringBuilder sb = new StringBuilder("");
    int c = read();
    while (isSpace(c)) c = read();
    do {
        sb.appendCodePoint(c);
        c = read();
    } while (!isSpace(c));
    return sb.toString();
}