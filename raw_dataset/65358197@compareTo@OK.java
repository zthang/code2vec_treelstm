public int compareTo(Game ob) {
    if (this.x < ob.x)
        return -1;
    else if (this.x > ob.x)
        return 1;
    return 0;
}