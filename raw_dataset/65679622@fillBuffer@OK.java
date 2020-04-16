private void fillBuffer() {
    try {
        bytesRead = in.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    } catch (IOException e) {
        throw new InputMismatchException();
    }
}