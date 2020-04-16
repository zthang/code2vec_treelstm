public String next() throws IOException {
    tokenizer.nextToken();
    return tokenizer.sval;
}