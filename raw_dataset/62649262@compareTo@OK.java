@Override
public int compareTo(Object o) {
    Pair<K, V> p = (Pair) o;
    if (p.key.compareTo(this.key) > 0)
        return 1;
    else if (p.key.compareTo(this.key) < 0)
        return -1;
    else {
        if (p.value.compareTo(this.value) > 0)
            return 1;
        else if (p.value.compareTo(this.value) < 0)
            return -1;
        else
            return 0;
    }
}