private boolean skip() throws IOException {
    if (!hasNextLine())
        return false;
    while (isSpaceChar(buf[now])) {
        if (!move())
            return false;
    }
    return true;
}