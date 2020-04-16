@Override
public int compareTo(pr o) {
    if (o.v == v)
        return 0;
    if (d[o.v] < d[v])
        return 1;
    return -1;
}