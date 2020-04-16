private void squish() {
    if (values.length > size * ratio * 2 + 10) {
        rebuild(size * ratio + 3);
    }
}