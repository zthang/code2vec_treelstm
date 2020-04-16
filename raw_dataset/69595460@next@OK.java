public String next() {
    try {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
    } catch (IOException e) {
        return null;
    }
    return tokenizer.nextToken();
}