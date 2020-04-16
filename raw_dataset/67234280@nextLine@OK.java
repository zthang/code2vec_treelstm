public String nextLine() {
    int c = skip();
    StringBuilder sb = new StringBuilder();
    while (!isEndOfLine(c)) {
        sb.appendCodePoint(c);
        c = readByte();
    }
    return sb.toString();
}