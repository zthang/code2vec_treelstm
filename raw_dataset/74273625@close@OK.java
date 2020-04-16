public void close() throws IOException {
    if (stream == null) {
        return;
    }
    stream.close();
}