/**
 * This will set st to null
 * Boolean at pos i true if char at pos i == c
 */
public boolean[] nextBoolArray(char c) throws IOException {
    char[] chars = nextCharArray();
    if (chars == null)
        return null;
    boolean[] booleans = new boolean[chars.length];
    for (int i = 0; i < chars.length; i++) {
        booleans[i] = chars[i] == c;
    }
    return booleans;
}