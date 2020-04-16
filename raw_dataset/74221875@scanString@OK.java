public String scanString() throws IOException {
    StringBuilder sb = new StringBuilder();
    int n = scan();
    while (isWhiteSpace(n)) n = scan();
    while (!isWhiteSpace(n) || n == ' ') {
        sb.append((char) n);
        n = scan();
    }
    return sb.toString();
}