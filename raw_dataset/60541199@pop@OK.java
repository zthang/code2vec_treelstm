int pop() {
    if (size == 0) {
        throw new NoSuchElementException();
    }
    return data[--size];
}