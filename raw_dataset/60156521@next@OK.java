public String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        tokenizer = new StringTokenizer(nextLine());
    }
    return tokenizer.nextToken();
}