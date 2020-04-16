public void flush() {
    try {
        os.write(cache.toString().getBytes(charset));
        os.flush();
        cache.setLength(0);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}