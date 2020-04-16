public // asc order
int compareTo(// asc order
Object o) {
    triplet tr = (triplet) o;
    if (t > tr.t)
        return 1;
    else
        return -1;
}