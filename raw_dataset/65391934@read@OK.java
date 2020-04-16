private byte read() throws Exception {
    if (bufferPointer == bytesRead) {
        fillBuffer();
    }
    return buffer[bufferPointer++];
}