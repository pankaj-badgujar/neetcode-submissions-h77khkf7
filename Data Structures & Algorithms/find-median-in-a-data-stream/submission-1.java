class MedianFinder {

    // here is the algo
    // for each num, check size of min and maxHeap
    // if size are eq, we would have put it in min, except if  el < maxTop -> then we rebalance
    // if size are !eq, we put it in max, except if el > minTop -> then we rebalance

    // rebalance means we dont put el to its destination, we put it to the other.
    // and we put other's top to destination


    private PriorityQueue<Double> minHeap;
    private PriorityQueue<Double> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    private void rebalance(double num, PriorityQueue<Double> destination, PriorityQueue<Double> other){
        if (other.size() > 0){
            destination.add(other.poll());
        }
        other.add(num);
    }
    
    public void addNum(int num) {
        double element = num;

        if (minHeap.size() == 0){
            minHeap.add(element);
            return;
        }

        if (minHeap.size() == maxHeap.size()){
            // num should go to minHeap, unless we need rebalance
            // dest is minHeap
            // check if we need rebalance
            if (element < maxHeap.peek()){
                rebalance(element, minHeap, maxHeap);
            } else {
                minHeap.add(element);
            }
        } else {
            // num should go to maxHeap, unless we need rebalance
            // dest is maxHeap
            if (element > minHeap.peek()){
                // System.out.println("el: "+ element + "minHeap.peek: " + minHeap.peek()+ " hence rebalancing");
                rebalance(element, maxHeap, minHeap);
            } else {
                maxHeap.add(element);
            }
        }
        
    }
    
    public double findMedian() {
        // System.out.println("minHeap: " + minHeap.toString());
        // System.out.println("maxHeap: " + maxHeap.toString());

        if (minHeap.size() == maxHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2;
        } 
        return minHeap.peek();
    }
}
