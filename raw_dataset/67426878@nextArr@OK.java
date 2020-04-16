public char[] nextArr() throws IOException {
    return readPRT() ? java.util.Arrays.copyOf(cBuff, itr) : null;
}