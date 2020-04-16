public int compareTo(Pair o) {
    if (epoc == o.epoc && st && !o.st)
        return -1;
    if (epoc == o.epoc && o.st && !st)
        return 1;
    return epoc - o.epoc;
}