private void fillBuffer() {
    try {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
    } catch (IOException e) {
        throw new RuntimeException("trying to read from null input, verify constraints ");
    }
    if (bytesRead == -1) {
        buffer[0] = -1;
    }
}