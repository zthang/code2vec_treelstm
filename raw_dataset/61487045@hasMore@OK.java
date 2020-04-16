public boolean hasMore() {
    skipBlank();
    return next != -1;
}