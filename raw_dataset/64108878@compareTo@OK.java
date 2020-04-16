public int compareTo(Edge e) {
    long dif = w - e.w;
    if (dif > 0)
        return 1;
    if (dif == 0)
        return 0;
    return -1;
}