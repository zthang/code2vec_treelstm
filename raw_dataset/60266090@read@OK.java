private int read() {
    while (bufLen == bufOffset) {
        bufOffset = 0;
        try {
            bufLen = is.read(buf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (bufLen == -1) {
            return -1;
        }
    }
    return buf[bufOffset++];
}