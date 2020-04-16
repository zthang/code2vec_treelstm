public void flush() throws IOException {
    os.write(cache.toString().getBytes(charset));
    os.flush();
    cache.setLength(0);
}