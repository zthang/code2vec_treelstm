public String read() {
    try {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
    } catch (IOException ex) {
        throw new RuntimeException(ex);
    }
    return tokenizer.nextToken();
}