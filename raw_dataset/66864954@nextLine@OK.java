public String nextLine() throws Exception {
    String line = null;
    tokenizer = null;
    line = reader.readLine();
    return line;
}