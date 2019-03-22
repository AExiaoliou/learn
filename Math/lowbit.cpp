//The easiest to remember and write
int lowbit(x) {
    return x & (-x);
}

//or 
int lowbit(x) {
    return x&-x; //but not intuitive for reader 
}

//this guy is the easiest to figure out by yourself
int lowbit(x) {
    return x & (x ^ (x - 1));
}
