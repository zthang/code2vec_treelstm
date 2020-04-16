private int readOutSpaces() throws IOException {
    while (true) {
        if (bufferPointer == bytesRead)
            fillBuffer();
        int c = buffer[bufferPointer++];
        if (!isSpaceChar(c)) {
            return c;
        }
    }
}