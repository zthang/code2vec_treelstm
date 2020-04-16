@Override
public int compareTo(edge t) {
    if (w < t.w)
        return -1;
    else if (w > t.w)
        return 1;
    return 0;
}