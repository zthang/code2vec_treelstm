String next() throws IOException {
    while (!tok.hasMoreElements()) tok = new StringTokenizer(in.readLine());
    return tok.nextToken();
}