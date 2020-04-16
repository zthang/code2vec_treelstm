public char[] nextLineArr() throws IOException {
    return readLINE() ? java.util.Arrays.copyOf(cBuff, itr) : null;
}