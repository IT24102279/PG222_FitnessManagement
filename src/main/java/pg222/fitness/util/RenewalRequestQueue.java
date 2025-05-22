package pg222.fitness.util;

import pg222.fitness.model.RenewalRequest;

public class RenewalRequestQueue {
    private int maxSize;
    private RenewalRequest[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public RenewalRequestQueue(int size) {
        maxSize = size;
        queueArray = new RenewalRequest[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(RenewalRequest req) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (rear == maxSize - 1) {  // Deal with wraparound
                rear = -1;
            }
            queueArray[++rear] = req;
            nItems++;
        }
    }
}