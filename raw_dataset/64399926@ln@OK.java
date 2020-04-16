public LightWriter ln() {
    print(System.lineSeparator());
    breaked = true;
    if (autoflush) {
        try {
            out.flush();
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
    return this;
}