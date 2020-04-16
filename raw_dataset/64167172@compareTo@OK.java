@Override
public int compareTo(Edge other) {
    return Long.compare(w, other.w);
}