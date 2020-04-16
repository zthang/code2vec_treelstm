public int compareTo(GraphPair o) {
    return w != o.w ? Long.compare(w, o.w) : Integer.compare(v, o.v);
}