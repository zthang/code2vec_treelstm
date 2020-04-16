public int compare(Pairl p1, Pairl p2) {
    if (p1.u - p2.u < 0) {
        return -1;
    } else if (p1.u - p2.u > 0) {
        return 1;
    } else {
        if (p1.v - p2.v < 0) {
            return -1;
        } else if (p1.v - p2.v > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}