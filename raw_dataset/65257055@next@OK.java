public String next() {
    if (this.buffer == null)
        this.buffer = new BufferedReader(new InputStreamReader(stream));
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
            tokenizer = new StringTokenizer(buffer.readLine() + "\n");
        } catch (IOException e) {
            throw new RuntimeException("IO exception occured!", e);
        }
    }
    return tokenizer.nextToken(spaceDelimiters);
}