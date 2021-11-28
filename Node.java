package HFM;

public class Node<T> implements Comparable<Node<T>> {
    private T data;
    private double weight;
    private Node<T> left;
    private Node<T> right;
    String code;

    public Node(T data, double weight){
        this.data = data;
        this.weight = weight;
        this.code = "";

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String str){
        code = str;
    }

    @Override
    public String toString(){
        return "data:"+this.data+";weight:"+this.weight+";code: "+this.code;
    }

    @Override
    public int compareTo(Node<T> other) {
        if(other.getWeight() > this.getWeight()){
            return 1;
        }
        if(other.getWeight() < this.getWeight()){
            return -1;
        }

        return 0;
    }
}

