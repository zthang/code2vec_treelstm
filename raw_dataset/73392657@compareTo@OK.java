@Override
public int compareTo(Pair<A, B> o) {
    int cmp = compare(first, o.first);
    return cmp == 0 ? compare(second, o.second) : cmp;
}