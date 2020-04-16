public int compareTo(pair o) {
    if (y == o.y)
        return x - o.x;
    return y - o.y;
}