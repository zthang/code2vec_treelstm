private boolean refill() throws IOException {
    len = reader.read(buf);
    now = 0;
    return len > 0;
}