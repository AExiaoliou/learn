double[] bucketSort(double[] a){
		final int bucketNum = a.length;
		DoubleStream stream = Arrays.stream(a);
		DoubleSummaryStatistics statistics = stream.summaryStatistics();
		final double d = (statistics.getMax() + statistics.getMin()) / (bucketNum - 1);
		List<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) bucketList.add(new LinkedList<>());
		stream.forEach(Collectors.groupingBy(val -> (int)(val - d) * ()));
	}
