public String readString() {
    defaultStringBuf.setLength(0);
    return readString(defaultStringBuf);
}