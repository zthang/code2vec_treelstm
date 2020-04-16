public int hashCode() {
    return (int) ((1l * (inf + 1) * this.first + this.second) % mod);
}