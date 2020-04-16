private String next() {
    char b;
    do {
        b = read();
        checkEof();
    } while (Character.isWhitespace(b));
    StringBuilder sb = new StringBuilder();
    do {
        sb.append(b);
        b = read();
    } while (!eof && !Character.isWhitespace(b));
    return sb.toString();
}