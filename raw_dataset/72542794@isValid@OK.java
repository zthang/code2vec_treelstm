static boolean isValid(int r, int c) {
    if (r >= 0 && c >= 0 && c < n && r < n)
        return true;
    return false;
}