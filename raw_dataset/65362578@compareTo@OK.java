@Override
public int compareTo(Pair<U, V> p) {
    int firstC = ((Comparable) first).compareTo((Comparable) p.first);
    if (firstC == 0)
        return ((Comparable) second).compareTo((Comparable) p.second);
    return firstC;
}