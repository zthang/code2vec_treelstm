public String nextLine() throws IOException {
    return readLINE() ? new String(cBuff, 0, itr) : null;
}