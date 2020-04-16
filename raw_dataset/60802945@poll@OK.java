public int poll() {
    if (from == to) {
        throw new NoSuchElementException();
    }
    int result = data[from++];
    from &= data.length - 1;
    return result;
}