public int read() {
    if (numChars == -1) {
        throw new RuntimeException();
    }
    if (curChar >= numChars) {
        curChar = 0;
        try {
            numChars = stream.read(buf);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        if (numChars <= 0) {
            return -1;
        }
    }
    return buf[curChar++];
}