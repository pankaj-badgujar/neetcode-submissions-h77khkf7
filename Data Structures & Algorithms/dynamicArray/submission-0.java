class DynamicArray {


    private int[] arr;
    private int end = -1;
    private int originalCapacity;

    public DynamicArray(int capacity) {
        arr = new int[capacity];
        originalCapacity = capacity;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
        end = Math.max(end, i);
    }

    public void pushback(int n) {
        // check if there is space left
        if(end == arr.length - 1){
            resize();
        }
        arr[++end] = n;
    }

    public int popback() {
        return arr[end--];
    }

    private void resize() {
        int[] temp = new int[2 * originalCapacity];
        
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
            end = i;
        }
        // assign arr to temp array
        arr = temp;

        // now new originalCapacity is twice the previous
        originalCapacity *= 2;
    }

    public int getSize() {
        return end + 1;
    }

    public int getCapacity() {
        return originalCapacity;
    }
}
