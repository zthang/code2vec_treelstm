public char nextChar() throws IOException {
    if (!hasNext())
        throw new NullPointerException();
    char tmp = buf[now];
    move();
    return tmp;
}