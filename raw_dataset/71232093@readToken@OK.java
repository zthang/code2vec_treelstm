private static String readToken() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
        tok = new StringTokenizer(br.readLine());
    }
    return tok.nextToken();
}