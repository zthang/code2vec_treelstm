public int compareTo(Animal o) {
    if (this.has != o.has)
        return this.has < o.has ? -1 : 1;
    if (this.idx != o.idx)
        return this.idx < o.idx ? -1 : 1;
    return 0;
}