public String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
            tokenizer = new StringTokenizer(reader.readLine());
        } catch (Exception e) {
        }
    }
    return tokenizer.nextToken();
}