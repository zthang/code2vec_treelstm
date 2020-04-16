static String nextString() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
        tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
}