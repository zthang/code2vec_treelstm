private void checkEof() {
    if (eof)
        throw new NoSuchElementException();
}