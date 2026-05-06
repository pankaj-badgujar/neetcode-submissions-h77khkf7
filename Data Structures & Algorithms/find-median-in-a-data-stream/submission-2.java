class MedianFinder {

    PriorityQueue<Double> maxHeap;
    PriorityQueue<Double> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        double element = num;
        maxHeap.add(element);

        // make sure every element in maxHeap is <= every element in minHeap
        if (maxHeap.size() >= 1 && minHeap.size() >= 1 && maxHeap.peek() > minHeap.peek()){
            minHeap.add(maxHeap.poll());
        }

        if (maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() > maxHeap.size() + 1){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        if (maxHeap.size() < minHeap.size()){
            return minHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2;
    }
}
