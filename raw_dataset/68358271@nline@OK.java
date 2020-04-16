private String nline() {
    int b = skip();
    StringBuilder sb = new StringBuilder();
    while (!isSpaceChar(b) || b == ' ') {
        sb.appendCodePoint(b);
        b = readByte();
    }
    return sb.toString();
}