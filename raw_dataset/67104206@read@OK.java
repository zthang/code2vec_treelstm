private char read() {
    if (!buffer.hasRemaining()) {
        buffer.clear();
        int n;
        try {
            n = in.read(buffer);
        } catch (IOException e) {
            n = -1;
        }
        if (n <= 0) {
            eof = true;
            return '\0';
        }
        buffer.flip();
    }
    return buffer.get();
}