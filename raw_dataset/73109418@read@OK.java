/**
 * Read the next byte of data from the input stream.
 *
 * @return the next byte of data, or -1 if the end of the stream is
 *         reached.
 * @throws IOException
 *             if an I/O error occurs.
 */
public byte read() throws IOException {
    if (bufferPointer == bytesRead)
        fillBuffer();
    return buffer[bufferPointer++];
}