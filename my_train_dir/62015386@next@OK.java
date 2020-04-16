public String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
            final String str = reader.readLine();
            tokenizer = new StringTokenizer(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    return tokenizer.nextToken();
}