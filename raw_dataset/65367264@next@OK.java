public String next() {
    while (tokenizer == null || !tokenizer.hasMoreElements()) {
        try {
            tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    return tokenizer.nextToken();
}