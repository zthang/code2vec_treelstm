public int compareTo(Point oth) {
    if (x == oth.x)
        return y - oth.y;
    return x - oth.x;
}