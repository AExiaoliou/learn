void Swaper(int[] arr, int a, int b){}//suppose we have a swaper
void quickSort(int[] a, int left, int right){
	int i = left, j = right;
	int pivot = a[(i + j) / 2];
	while (i <= j){
		while (a[i] < pivot) i++;
		while (a[j] > pivot) j--;
		if (i <= j) {
			Swaper(a, i, j);
			i++; j--;
		}
	}
	if (left < j) quickSort(a, left, j);
	if (i < right) quickSort(a, i, right);
}
