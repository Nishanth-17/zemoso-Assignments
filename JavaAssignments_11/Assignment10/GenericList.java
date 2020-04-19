class Node<T>{
    protected Node<T> next;
    protected T data;
    Node(T d){
        data=d;
        next=null;
    }
}
class SList<T>{
    protected Node<T> head;
    public SListIterator<T> newIterator(){
        SListIterator<T> sListIterator=new SListIterator<>(head);
        return sListIterator;
    }
}
class SListIterator<T> implements NewIterator<T>{
    private Node<T> head;
    public SListIterator(Node<T> head){
        this.head=head;
    }
    //Insert an element into linked list
    public Node<T> insert(T data){
        Node<T> newnode=new Node<T>(data);
        newnode.next=null;
        if(head==null){
            head=newnode;
        }
        else{
            Node temp=head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next=newnode;
        }
        return head;
    }
    //Remove a particular element from a linked list
    public Node<T> delete(T data){
        Node temp=head;
        if(head==null)
            return head;
        if(head.data==data){
            head=head.next;
            return head;
        }
        while(temp.next!=null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                return temp;
            }
            temp=temp.next;
        }
        return temp;
    }

    public void printList(){
        Node currNode=head;
        while (currNode!=null){
            System.out.println(currNode.data);
            currNode=currNode.next;
        }
    }
}
interface NewIterator<T>{
    public Node<T> insert(T data);
    public Node<T> delete(T data);
    public void printList();
}
public class GenericList {
    public static void main(String args[]) {
        SList<Integer> values=new SList<>();
        SListIterator<Integer> iter=values.newIterator();
        iter.insert(10);
        iter.insert(20);
        iter.insert(30);
        iter.insert(40);
        iter.insert(50);
        iter.insert(60);
        iter.printList();
        System.out.println();
        iter.delete(40);
        iter.printList();
    }
}
