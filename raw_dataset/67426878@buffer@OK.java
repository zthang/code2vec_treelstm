public char[] buffer() throws IOException {
    return readPRT() ? cBuff : null;
}