package task.list;

public class Node<T> {
    private T data;
    private Node<T> prev;
    private Node<T> next;
    private boolean isHead;

    public Node(T nodeData, Node<T> prevNode, Node<T> nextNode){
        data = nodeData;
        prev = prevNode;
        next = nextNode;
        isHead = false;
    }


    public T getData() {
        return data;
    }

    public void setData(T newData) {
        data = newData;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> nextNode){
        next = nextNode;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prevNode){
        prev = prevNode;
    }

    public boolean isHead () {
        return isHead;
    }

    public void useAsHead() {
        isHead = true;
    }
}
