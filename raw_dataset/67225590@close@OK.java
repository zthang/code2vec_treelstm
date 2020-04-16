public void close() {
    flush();
    try {
        os.close();
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }
}