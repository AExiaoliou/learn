int* countingSort(int[] a, int len) {
    int counter[10000];
    memset(counter, 0, sizeof(counter));
    for (int i = 0; i < len; i++) {
        counter[a[i]]++;
    }
    int* res = new int [n];
    for (int i = 0, j = 0; i < 10000 && j < len; ){
        if (counter[i] > 0) {
            arr[j] = i;
            counter[i]--;
            j++;
        }else i++;
    }
    return res;
}
