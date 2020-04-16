/**
 * This will set st to null
 */
public char[] nextCharArray() throws IOException {
    st = null;
    String s = br.readLine();
    return s == null ? null : s.toCharArray();
}