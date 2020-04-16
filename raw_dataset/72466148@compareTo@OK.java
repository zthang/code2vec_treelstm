@Override
public int compareTo(pair o) {
    if (to == o.to)
        return number - o.number;
    return to - o.to;
}