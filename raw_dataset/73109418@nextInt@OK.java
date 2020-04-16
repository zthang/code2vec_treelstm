/**
 * Read the next integer from the input stream.
 *
 * @return The next integer.
 * @throws IOException
 */
public int nextInt() throws IOException {
    int result = 0;
    byte c = read();
    while (c <= ' ') c = read();
    boolean neg = (c == '-');
    if (neg)
        c = read();
    while (c >= '0' && c <= '9') {
        result = result * 10 + c - '0';
        c = read();
    }
    if (neg)
        return -result;
    return result;
}