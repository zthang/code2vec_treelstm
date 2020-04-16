public String nextLine() {
    if (this.buffer == null)
        this.buffer = new BufferedReader(new InputStreamReader(stream));
    while (tokenizer == null) {
        try {
            tokenizer = new StringTokenizer(buffer.readLine() + "\n");
        } catch (IOException e) {
            throw new RuntimeException("IO exception occured!", e);
        }
    }
    String res = tokenizer.nextToken("");
    if (!res.endsWith("\n"))
        throw new RuntimeException("waddaheq just heppenenened");
    res = res.substring(0, res.length() - 1);
    if (res.contains("\n"))
        throw new RuntimeException("oke wat lamo");
    tokenizer = null;
    return res;
}