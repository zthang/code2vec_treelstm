public int compareTo(Spec other) {
    if (x == other.x) {
        return i - other.i;
    }
    return other.x - x;
}