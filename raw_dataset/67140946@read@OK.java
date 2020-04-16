public int read() {
    if (znumChars == -1)
        throw new InputMismatchException();
    if (zcurChar >= znumChars) {
        zcurChar = 0;
        try {
            znumChars = stream.read(buf);
        } catch (IOException e) {
            throw new InputMismatchException();
        }
        if (znumChars <= 0)
            return -1;
    }
    return buf[zcurChar++];
}