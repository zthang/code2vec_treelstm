public int compareTo(pair<U, V> other) {
    int i = x.compareTo(other.x);
    if (i != 0)
        return i;
    return y.compareTo(other.y);
}