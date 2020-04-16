public int compareTo(Pair<F, S> other) {
    int fd = this.first.compareTo(other.first);
    if (fd != 0)
        return fd;
    else
        return this.second.compareTo(other.second);
}