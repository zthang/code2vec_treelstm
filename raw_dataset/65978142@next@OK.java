static String next() throws IOException {
    while (!tokenizer.hasMoreTokens()) {
        // TODO add check for eof if necessary
        tokenizer = new StringTokenizer(reader.readLine());
    }
    return tokenizer.nextToken();
}