public int compareTo(Pair o) {
    if (o.value == value)
        return Double.compare(value2, o.value);
    return Long.compare(value, o.value);
}