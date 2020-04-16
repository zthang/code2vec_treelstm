public int peek() {
    if (from == to) {
        throw new NoSuchElementException();
    }
    return data[from];
}