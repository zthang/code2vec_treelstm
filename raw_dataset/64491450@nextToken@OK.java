String nextToken() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (line == null) {
            return null;
        }
        tokenizer = new StringTokenizer(line);
    }
    return tokenizer.nextToken();
}