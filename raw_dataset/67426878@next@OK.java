public String next() throws IOException {
    return readPRT() ? new String(cBuff, 0, itr) : null;
}