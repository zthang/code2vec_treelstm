@Override
public int compare(Node arg0, Node arg1) {
    int a = arg0.id;
    int b = arg1.id;
    if (left[a] != left[b])
        return left[a] - left[b];
    return right[a] - right[b];
}