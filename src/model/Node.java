package model;

public class Node<T> { 

    private T dataItems;
    private Node nextNode;

    public void setNextNode(Node _nextNode){
        this.nextNode=_nextNode;
    }

    public Node getNextNode(){
        return nextNode;
    }

    public T getDataItems(){
        return dataItems;
    }

    public void setDataItems(T _dataItems){
        this.dataItems=_dataItems;
    }

}