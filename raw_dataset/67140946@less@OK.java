public boolean less(int i, int j) {
    if (comparator == null) {
        return ((Comparable<Key>) keys[pq[i]]).compareTo(keys[pq[j]]) < 0;
    } else {
        return comparator.compare(keys[pq[i]], keys[pq[j]]) < 0;
    }
}