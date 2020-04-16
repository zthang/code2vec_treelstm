@Override
public String toString() {
    if (denom < 0) {
        this.num = -this.num;
        this.denom = -this.denom;
    }
    if (num == 0)
        return "0";
    return (num + "/" + denom);
}