@Override
public int compareTo(Query o) {
    if (weight == o.weight)
        return index - o.index;
    return weight - o.weight;
}