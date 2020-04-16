private void fillBuffer() throws Exception {
    bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
    if (bytesRead == -1) {
        buffer[0] = -1;
    }
}