public int compare(Combine a, Combine b) {
    if (a.value > b.value)
        return 1;
    else if (a.value == b.value && a.delete > b.delete)
        return 1;
    else if (a.value == b.value && a.delete == b.delete)
        return 0;
    return -1;
}