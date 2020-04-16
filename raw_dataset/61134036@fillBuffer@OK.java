private void fillBuffer() throws IOException {
    if (din == null) {
        bufferPointer = 0;
        bytesRead = -1;
    } else {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
    }
    if (bytesRead == -1)
        buffer[0] = -1;
}