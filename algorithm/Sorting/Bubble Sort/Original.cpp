void Swaper(int& a, int& b) {}//suppose we have a swaper
void BubbleSort(int a[], int len) {
	for (int i = 0; i < len - 1; i++) 
		for (int j = i + 1; j < len; j++) 
			if (a[i] > a[j]) Swaper(a[i], a[j]);
}
