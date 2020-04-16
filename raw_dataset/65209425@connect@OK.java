boolean connect(int A, int B) {
    A = root(A);
    B = root(B);
    if (A == B) {
        return false;
    }
    // }
    if (A < B) {
        int temp = A;
        A = B;
        B = temp;
    }
    Parent.set(A, Parent.get(A) + Parent.get(B));
    Parent.set(B, A);
    return true;
}