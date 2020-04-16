public String nextString() {
    try {
        return reader.readLine();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}