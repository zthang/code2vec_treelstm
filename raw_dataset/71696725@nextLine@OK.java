public String nextLine() {
    String line = null;
    try {
        tokenizer = null;
        line = reader.readLine();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return line;
}