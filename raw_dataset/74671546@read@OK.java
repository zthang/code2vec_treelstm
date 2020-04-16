public int read() {
    if (curCharIdx >= nChars) {
        try {
            curCharIdx = 0;
            nChars = is.read(buffer);
            if (nChars == -1)
                return -1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    return buffer[curCharIdx++];
}