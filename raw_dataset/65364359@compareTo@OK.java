public int compareTo(tripletL o) {
    int result = x.compareTo(o.x);
    if (result == 0)
        result = y.compareTo(o.y);
    if (result == 0)
        result = z.compareTo(o.z);
    return result;
}