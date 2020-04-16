public int compareTo(Interval i2) {
    if (l - i2.l != 0) {
        return l - i2.l;
    } else {
        return i2.r - r;
    }
}