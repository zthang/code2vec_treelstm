public void add(int value) {
    ensureCapacity((realSize + 1) * ratio + 2);
    int current = getHash(value);
    while (present[current] != 0) {
        if ((present[current] & PRESENT_MASK) != 0 && values[current] == value) {
            return;
        }
        current += step;
        if (current >= values.length) {
            current -= values.length;
        }
    }
    while ((present[current] & PRESENT_MASK) != 0) {
        current += step;
        if (current >= values.length) {
            current -= values.length;
        }
    }
    if (present[current] == 0) {
        realSize++;
    }
    present[current] = PRESENT_MASK;
    values[current] = value;
    size++;
}