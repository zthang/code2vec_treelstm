String next() throws IOException {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        String line = br.readLine();
        if (line == null) {
            return null;
        }
        tokenizer = new StringTokenizer(line);
    }
    return tokenizer.nextToken();
}