/**
 * Read data from the input stream into the buffer
 *
 * @throws IOException
 *             if an I/O error occurs.
 */
private void fillBuffer() throws IOException {
    bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
    if (bytesRead == -1)
        buffer[0] = -1;
}