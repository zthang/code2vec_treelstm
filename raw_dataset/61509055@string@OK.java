public String string() {
    if (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
            tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    return tokenizer.nextToken();
}