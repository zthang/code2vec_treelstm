@Override
public int compareTo(Edge o) {
    return Long.compare(weight, o.weight);
}