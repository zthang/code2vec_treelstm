public int compareTo(Edge<T> o) {
    return Double.compare(weight, o.weight);
}