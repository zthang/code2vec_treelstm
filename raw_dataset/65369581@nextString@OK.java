/**
 * @return
 * @throws IOException
 */
public String nextString() throws IOException {
    // Skip all whitespace characters from the stream
    byte c = read();
    while (Character.isWhitespace(c)) {
        c = read();
    }
    StringBuilder builder = new StringBuilder();
    builder.append((char) c);
    c = read();
    while (!Character.isWhitespace(c)) {
        builder.append((char) c);
        c = read();
    }
    return builder.toString();
}