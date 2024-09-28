class MyCircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Initialize the deque with a fixed size k.
    public MyCircularDeque(int k) {
        deque = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    // Add an element at the front of the deque.
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity; // Circular decrement
        deque[front] = value;
        size++;
        return true;
    }

    // Add an element at the rear of the deque.
    public boolean insertLast(int value) {
        if (isFull()) return false;
        deque[rear] = value;
        rear = (rear + 1) % capacity; // Circular increment
        size++;
        return true;
    }

    // Delete an element from the front of the deque.
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity; // Circular increment
        size--;
        return true;
    }

    // Delete an element from the rear of the deque.
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity; // Circular decrement
        size--;
        return true;
    }

    // Get the front item from the deque.
    public int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }

    // Get the last item from the deque.
    public int getRear() {
        if (isEmpty()) return -1;
        return deque[(rear - 1 + capacity) % capacity]; // Adjust for circular
    }

    // Check whether the deque is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Check whether the deque is full.
    public boolean isFull() {
        return size == capacity;
    }
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */