void setLazy(int time, int lazy) {
    if (this.time != 0 && this.time <= time)
        return;
    this.time = time;
    this.lazy = lazy;
}