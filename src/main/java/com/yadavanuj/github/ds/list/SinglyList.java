package com.yadavanuj.github.ds.list;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * append
 * prepend
 * insertAt
 */

public class SinglyList {

    /**
     * A nested class. Given a blanket namespace by SinglyList.
     */

    @Getter
    @Setter
    @Builder
    public static class Node {
        private int data;
        private Node next;
    }

    private Node head;

    public Node append(int data) {
        // Empty List -> Head will be null
        final Node temp = Node.builder().data(data).build();
        if (Objects.isNull(head)) {
            this.head = temp;
            return this.head;
        }

        // We have non-empty list
        Node holder = head;
        // As head is not null, we can test for nullability of the next
        while (Objects.nonNull(holder.getNext())) {
            holder = holder.getNext();
        }

        holder.setNext(temp);
        return head;
    }

    public Node prepend(int data) {
        // Empty List -> Head will be null
        final Node temp = Node.builder().data(data).build();
        if (Objects.isNull(head)) {
            this.head = temp;
            return this.head;
        }

        // We have non-empty list
        temp.setNext(head);
        this.head = temp;
        return this.head;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (Objects.isNull(head)) {
            return "n empty list!";
        }
        Node temp = head;
        while (true) {
            if (Objects.nonNull(temp)) {
                output.append(String.format(" %d ", temp.getData()));
                temp = temp.getNext();
            } else {
                break;
            }
        }

        return output.toString();
    }
}
