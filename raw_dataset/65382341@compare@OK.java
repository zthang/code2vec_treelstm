public int compare(hold a, hold b) {
    if (a.value < b.value)
        return -1;
    else if (a.value == b.value)
        return 0;
    else
        return 1;
}