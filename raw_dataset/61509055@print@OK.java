public LightWriter print(String s) {
    try {
        out.write(s, 0, s.length());
        breaked = false;
    } catch (IOException ex) {
        throw new UncheckedIOException(ex);
    }
    return this;
}