public int compareTo(Point a) {
    if (this.mi - a.mi != 0)
        return this.mi - a.mi;
    return this.mx - a.mx;
}