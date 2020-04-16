private void validate(int n, int start, int end) {
    if (start < 0 || end >= n) {
        throw new IllegalArgumentException();
    }
}