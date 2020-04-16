private int read() {
    if (numchars == -1)
        throw new InputMismatchException();
    if (curchar >= numchars) {
        curchar = 0;
        try {
            numchars = stream.read(arr);
        } catch (IOException e) {
            throw new InputMismatchException();
        }
        if (numchars <= 0)
            return -1;
    }
    return arr[curchar++];
}