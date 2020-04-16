@Override
public boolean equals(Object e1) {
    Edge temp = (Edge) e1;
    if (this.n1 == temp.n1 && this.n2 == temp.n2)
        return true;
    return false;
}