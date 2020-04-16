private void reverse(char[] a, int i, int j) {
    while (i < j) {
        swap(a, i++, j--);
    }
}