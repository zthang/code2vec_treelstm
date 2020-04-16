public int compareTo(p o) {
    return -(Integer.bitCount(this.mask) - Integer.bitCount(o.mask));
}