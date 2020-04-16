int max() {
    int max = 0;
    for (int i = 0; i < size.length; i++) if (size[i] > max)
        max = size[i];
    return max;
}