public String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
            tokenizer = new StringTokenizer(readLine());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    return tokenizer.nextToken();
}