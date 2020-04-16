public int compareTo(Pair obj) {
    if (this.second < obj.second)
        return -1;
    if (this.second > obj.second)
        return 1;
    return 0;
}