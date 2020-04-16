int root(int A) {
    if (Parent.get(A) < 0)
        return A;
    int root = root(Parent.get(A));
    Parent.set(A, root);
    return root;
}