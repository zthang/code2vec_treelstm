public boolean hasNext() throws IOException {
    int res = tokenizer.nextToken();
    tokenizer.pushBack();
    return res != tokenizer.TT_EOF;
}