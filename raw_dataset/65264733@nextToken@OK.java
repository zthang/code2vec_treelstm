String nextToken() {
    try {
        while (!tokenizer.hasMoreTokens()) tokenizer = new StringTokenizer(in.readLine());
    } catch (Exception e) {
    }
    return tokenizer.nextToken();
}