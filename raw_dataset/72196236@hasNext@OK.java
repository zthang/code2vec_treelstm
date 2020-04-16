public boolean hasNext() {
    boolean hasnext = true;
    try {
        hasnext = stream.available() != 0;
    } catch (IOException e) {
    }
    return hasnext || curChar < snumChars;
}