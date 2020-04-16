public int nextInt() {
    long nl = nextLong();
    if (nl < Integer.MIN_VALUE || Integer.MAX_VALUE < nl) {
        throw new NumberFormatException();
    }
    return (int) nl;
}