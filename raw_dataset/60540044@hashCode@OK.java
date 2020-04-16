public int hashCode() {
    int result = 0;
    for (IntIterator it = intIterator(); it.isValid(); it.advance()) {
        result *= 31;
        result += it.value();
    }
    return result;
}