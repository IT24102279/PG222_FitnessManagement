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