public void skipBlank() {
    while (next >= 0 && next <= 32) {
        next = read();
    }
}