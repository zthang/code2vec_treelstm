int nextC() {
    try {
        return reader.read();
    } catch (IOException e) {
        return -1;
    }
}