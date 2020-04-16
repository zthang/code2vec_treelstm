public void close() {
    try {
        out.close();
    } catch (IOException ex) {
        throw new UncheckedIOException(ex);
    }
}