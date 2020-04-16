boolean hasNext() {
    while (!tokenizer.hasMoreTokens()) {
        String line = nextLine();
        if (line == null) {
            return false;
        }
        tokenizer = new StringTokenizer(line);
    }
    return true;
}