String next() {
    while (!tokenizer.hasMoreTokens()) tokenizer = new StringTokenizer(nextLine());
    return tokenizer.nextToken();
}