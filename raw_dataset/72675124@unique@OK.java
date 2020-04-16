public void unique() {
    if (size <= 1) {
        return;
    }
    sort();
    int wpos = 1;
    for (int i = 1; i < size; i++) {
        if (data[i] != data[wpos - 1]) {
            data[wpos++] = data[i];
        }
    }
    size = wpos;
}