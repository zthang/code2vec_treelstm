void build(int index, int left, int right) {
    if (left == right) {
        tree[index] = arr[left];
    } else {
        int mid = (left + right) / 2;
        build(index * 2, left, mid);
        build((index * 2) + 1, mid + 1, right);
        tree[index] = max(tree[(index * 2)], tree[(index * 2) + 1]);
    }
}