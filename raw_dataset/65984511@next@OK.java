String next() throws IOException {
    if (!tok.hasMoreTokens()) {
        tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
}