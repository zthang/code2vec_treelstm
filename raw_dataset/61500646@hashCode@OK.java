public int hashCode() {
    return Long.hashCode(a) * 27 + Long.hashCode(b) * 31 + Long.hashCode(c) * 3;
}