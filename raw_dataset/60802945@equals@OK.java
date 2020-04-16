public boolean equals(Object o) {
    if (!(o instanceof IntStream)) {
        return false;
    }
    IntStream c = (IntStream) o;
    IntIterator it = intIterator();
    IntIterator jt = c.intIterator();
    while (it.isValid() && jt.isValid()) {
        if (it.value() != jt.value()) {
            return false;
        }
        it.advance();
        jt.advance();
    }
    return !it.isValid() && !jt.isValid();
}