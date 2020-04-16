public boolean hasNext() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
            String nextLine = reader.readLine();
            if (nextLine == null)
                return false;
            tokenizer = new StringTokenizer(nextLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    return tokenizer.hasMoreTokens();
}