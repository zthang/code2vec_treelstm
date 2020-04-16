public int compareTo(Token o) {
    if (len != o.len) {
        return len - o.len;
    }
    int r = compare(len / 9, head, o.head);
    if (r != 0) {
        return r;
    }
    if (tail != o.tail) {
        return Integer.compare(tail, o.tail);
    }
    return id - o.id;
}