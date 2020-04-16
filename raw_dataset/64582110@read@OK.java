private byte read() {
    if (bufferPointer == bytesRead) {
        fillBuffer();
    }
    return buffer[bufferPointer++];
}