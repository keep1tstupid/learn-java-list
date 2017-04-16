package task.list;

import task.list.Node;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.LinkedList;

public class MyLinkedList<T> implements Iterable<T>, Iterator<T> {
    private Node<T> head;
    private Node<T> iteratorCursor;

    public MyLinkedList() {
        head = new Node<T>(null, null, null);
        head.useAsHead();
    }

    private Node<T> findLast() {
        Node<T> tmp = head;
        while (tmp.getNext() != null){
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public void addLast (T content) {
        Node<T> lastNode = findLast();
        Node<T> newNode = new Node<T> (content, lastNode, null);
        lastNode.setNext(newNode);
    }

    public void removeLast() {
        Node<T> lastNode = findLast();
        lastNode.getPrev().setNext(null);
        lastNode.setPrev(null);
    }

    public LinkedList<T> reverse() {
        LinkedList<T> reversedList = new LinkedList<T>();
        Node<T> tmp = findLast();
        while(!tmp.getPrev().isHead()){
            reversedList.addLast(tmp.getData());
            tmp = tmp.getPrev();
        }
        reversedList.addLast(tmp.getData());
        return reversedList;
    }

    public String toString() {
        String showList = "HEAD";
        for (T node: this) {
            showList = showList.concat(" > ").concat(node.toString());
        }
        return showList;
    }

    public Iterator<T> iterator(){
        iteratorCursor = head;
        return this;
    }

    public boolean hasNext() {
        return iteratorCursor.getNext() != null;
    }

    public T next() {
        if (!hasNext()){
            iteratorCursor = head;
            throw new NoSuchElementException();
        }

        iteratorCursor = iteratorCursor.getNext();
        return iteratorCursor.getData();
    }
}

