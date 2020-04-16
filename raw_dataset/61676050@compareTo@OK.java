public int compareTo(query n) {
    if (this.data != n.data)
        return this.data - n.data;
    return this.indx - n.indx;
}