public boolean hasNext() {
    try {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
    } catch (Exception e) {
        return false;
    }
    return true;
}