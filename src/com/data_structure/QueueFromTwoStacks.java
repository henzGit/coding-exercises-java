package com.data_structure;

import java.util.Stack;

/**
 * Queue class using two internal stacks: inbox and outbox
 * @param <T> Generic type
 */
public class QueueFromTwoStacks<T> {
    private Stack<T> inbox;
    private Stack<T> outbox;

    public QueueFromTwoStacks(){
        inbox = new Stack<T>();
        outbox = new Stack<T>();
    }

    /**
     * Put an item to the queue
     * @param item item to be enqueued
     */
    public void enqueue(T item){
        inbox.push(item);
    }

    /**
     * Get an item from the queue if it is not empty
     * Otherwise return null
     * @return item from the queue
     */
    public T dequeue(){
        if (outbox.empty()) {
            while (!inbox.empty()) {
                outbox.push(inbox.pop());
            }
        }

        if (!outbox.empty()) {
            return outbox.pop();
        }
        return null;
    }
}
