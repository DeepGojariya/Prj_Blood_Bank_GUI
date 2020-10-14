package model;

public class LinkedList<Data> {
	
	HeadNode head;
	
	public LinkedList(){
	    head = new HeadNode();
	}
	
	public void insertNode(Data _data){
	    Node newNode = new Node();
	    newNode.setDataItems(_data);
	    Node nextNode = head.getNextNode();
	    head.setNextNode(newNode);
	    newNode.setNextNode(nextNode);
		
	}
	
	public void deleteNode(){
	    Node toBeDeletedNode = head.getNextNode();
	    if(toBeDeletedNode!=null) {
	        Node nextNode = toBeDeletedNode.getNextNode();
	        head.setNextNode(nextNode);
	        toBeDeletedNode.setNextNode(null);
	    } else {
	        System.out.println("No nodes to be deleted");
	    }
	}
	
	public String displayList(){
	    Node<Data> nodes = head.getNextNode();
	    String str = null;
	    int i=0;
	    while(nodes!=null) {
	        Data data = nodes.getDataItems();
	        str = (data.toString()) + str;
	        nodes = nodes.getNextNode();
	        i++;
	    }
	    return str;
	}
	
	public void reverseLinkedList(){
	    int sizeOfList = size();
	    Node lastNode = nodeAtIndex(sizeOfList-1);
	    Node snode, tnode;
	    for(int i=sizeOfList-2;i>=0;i--){
	        snode = nodeAtIndex(i);
	        tnode = snode.getNextNode();
	        tnode.setNextNode(snode);
	    }
	    nodeAtIndex(0).setNextNode(null);
	    head.setNextNode(lastNode);
	}
	
	public void insertNodeAtIndex(int _index, Data _data){
	    Node<Data>newNode = new Node();
	    newNode.setDataItems(_data);
	    if(_index==0) {
	        insertNode(_data);
	    } else {
	        Node prevNode = nodeAtIndex(_index-1);
	        if(prevNode!=null) {
	            Node nextNode = prevNode.getNextNode();
	            newNode.setNextNode(nextNode);
	            prevNode.setNextNode(newNode);
	        }
	    }
	}
	
	public void deleteNodeAtIndex(int _index){
	    if(_index==0) {
	        deleteNode();
	    } else {
	        Node prevNode = nodeAtIndex(_index-1);
	        if(prevNode!=null) {
	            Node targetNode = prevNode.getNextNode();
	            Node nextNode = targetNode.getNextNode();
	            targetNode.setNextNode(null);
	            prevNode.setNextNode(nextNode);
	        }
	    }
	}
	
	public Data dataAtNodeIndex(int _index){
	    Node<Data> nodes = nodeAtIndex(_index);
	    if(nodes!=null) {
	    return nodes.getDataItems();
	} else {
	    return null;
	}
	}
	
	private Node nodeAtIndex(int _index){
	    if(_index<0) {
	        return null;
	    } else {
	        Node nodes = head.getNextNode();
	        int i=0;
	        while(i<_index && nodes!=null) {
	            nodes = nodes.getNextNode();
	            i++;
	        }
	        return nodes;
	    }
	}
	
	public int size() {
	    int count=0;
	    Node nodes = nodeAtIndex(count);
	    while(nodes!=null) {
	        nodes = nodeAtIndex(++count);
	    }
	    return count;
	}

}
