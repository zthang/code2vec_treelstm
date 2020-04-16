@Override
public int compareTo(Edge arg) {
    if (this.weight < arg.weight)
        return -1;
    if (this.weight == arg.weight)
        return 0;
    return 1;
}