/**
 * @return
 * @throws IOException
 */
public char nextChar() throws IOException {
    byte c = read();
    while (Character.isWhitespace(c)) {
        c = read();
    }
    return (char) c;
}