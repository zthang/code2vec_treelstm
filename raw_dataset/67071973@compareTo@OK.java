public int compareTo(pair o) {
    int result = x.compareTo(o.x);
    if (result == 0)
        result = y.compareTo(o.y);
    return result;
}