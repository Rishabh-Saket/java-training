
public interface TMList<T>
{
    public void add(T data);
    public void add(int index,T data);

    public void insert(int index,T data);

    public void removeAll();
    public T removeAt(int index);
    public void clear();

    public int size();
    public T get(int index);

    public void update(int index, T data);

    public void copyTo(TMList<T> other); // copy one list to another
    public void copyFrom(TMList<T> other);

    public void appendTo(TMList<T> other);
    public void appendFrom(TMList<T> other);

}

// if I want to add a generic parameter to a method then I can use T type remove ist index 
// the remove function of List(ArrayList,LinkedList) returns the element
// int a=arr.remove(0);


