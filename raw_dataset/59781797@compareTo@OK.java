public int compareTo(Pairl other) {
    if (index != other.index)
        return Long.compare(index, other.index);
    return Long.compare(v, other.v) != 0 ? Long.compare(v, other.v) : Long.compare(u, other.u);
}