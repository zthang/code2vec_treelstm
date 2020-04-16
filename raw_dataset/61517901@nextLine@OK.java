public String nextLine() {
    try {
        return reader.readLine();
    } catch (Exception e) {
        return tokenizer.nextToken();
    }
}