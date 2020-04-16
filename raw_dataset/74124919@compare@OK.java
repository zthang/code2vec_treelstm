public int compare(pair one, pair two) {
    if (one.a > two.a)
        return 1;
    else if (one.a == two.a)
        return 0;
    else
        return -1;
}