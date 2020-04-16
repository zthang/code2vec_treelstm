public int compare(Pair a, Pair b) {
    if (a.val > b.val) {
        return 1;
    } else if (b.val > a.val) {
        return -1;
    } else
        return 0;
}