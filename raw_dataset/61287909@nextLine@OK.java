String nextLine() {
    if (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    return tokenizer.nextToken("\n");
}