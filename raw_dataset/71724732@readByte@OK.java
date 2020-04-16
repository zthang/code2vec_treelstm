private int readByte() {
    if (bufSz == -1)
        throw new RuntimeException("Reading past EOF");
    if (bufPtr >= bufSz) {
        bufPtr = 0;
        try {
            bufSz = is.read(buf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (bufSz <= 0)
            return -1;
    }
    return buf[bufPtr++];
}