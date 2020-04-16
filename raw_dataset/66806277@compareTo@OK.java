public int compareTo(pair p) {
    return (x - p.x == 0) ? y - p.y : x - p.x;
}