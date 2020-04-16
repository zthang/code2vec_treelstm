String next() throws IOException {
    int c = br.read();
    while (c <= 32) {
        c = br.read();
    }
    StringBuilder sb = new StringBuilder();
    while (c > 32) {
        sb.append((char) c);
        c = br.read();
    }
    return sb.toString();
}