public boolean remove(int value) {
    int current = getHash(value);
    while (present[current] != 0) {
        if (values[current] == value && (present[current] & PRESENT_MASK) != 0) {
            present[current] = REMOVED_MASK;
            size--;
            squish();
            return true;
        }
        current += step;
        if (current >= values.length) {
            current -= values.length;
        }
    }
    return false;
}