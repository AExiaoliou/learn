	static int[] calArraySum(int[] a, int low,int mid, int high) {
		int leftSum = -INF, rightSum = -INF;
		int maxLeft = 0, maxRight= 0;
		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum += a[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		for (int i = mid + 1; i < high; i++) {
			sum += a[i];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = i;
			}
		}
		return new int[] {maxLeft, maxRight, leftSum + rightSum};
	}

	static int[] maximumSubArray(int[] a, int low, int high) {
		if (high - low == 1) return new int[] {low, high, a[low]};
		else {
			int mid = (high + low) / 2;
			int[] left = maximumSubArray(a, low, mid);
			int[] right = maximumSubArray(a, mid, high);
			int[] cross = calArraySum(a, low, mid, high);
			if (left[2] >= right[2] && left[2] >= cross[2] ) return left;
			else if (right[2] >= left[2] && right[2] >= cross[2]) return right;
			else return cross;
		}
	}
