public String next() throws Exception {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) tokenizer = new StringTokenizer(reader.readLine());
    return tokenizer.nextToken();
}