public String next() throws IOException {
    if (Objects.isNull(tokenizer) || !tokenizer.hasMoreTokens())
        tokenizer = new StringTokenizer(reader.readLine());
    return tokenizer.nextToken();
}