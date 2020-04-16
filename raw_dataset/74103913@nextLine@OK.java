String nextLine() {
    try {
        String line = br.readLine();
        if (line == null) {
            throw new RuntimeException("empty line");
        }
        return line;
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}