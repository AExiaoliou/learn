//calculate a^b

//without modder
long qpow(long a, long b) {
    int res = 1, base = a;
    while(b){
        if(b&1) res *= base;
        base *= base;
        base >>= 1;
    }
    return res;
}

//with modder
long modpow(long a, long b, long modder){
    mod = modder;
    long res = 1, base = a % mod;
    while(b){
        if(b&1)  res = res * base % mod
        base = base * base % mod;
        base >>= 1;
    }
    return res;
}
