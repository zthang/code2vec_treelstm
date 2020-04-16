static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) tok = new StringTokenizer(in.readLine());
    return tok.nextToken();
}