String nextLine() throws IOException {
    int c = read();
    while (c != -1 && isEndline(c)) c = read();
    if (c == -1) {
        return null;
    }
    StringBuilder res = new StringBuilder();
    do {
        if (c >= 0) {
            res.appendCodePoint(c);
        }
        c = read();
    } while (!isEndline(c));
    return res.toString();
}