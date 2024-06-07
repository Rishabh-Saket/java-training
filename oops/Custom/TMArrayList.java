
public class TMArrayList<T> implements TMList<T> 
{
    private Object collection[]; // T a[];
    // reason behind taking object type array because T is unkown to JVM corresponding to array
    private int size;

    public TMArrayList()
	{
		this.collection=new Object[10];
		this.size=0;
	}
	
	public void add(T data)
	{
		if(this.size==this.collection.length)
		{
			Object temp[]=new Object[this.size+10];
			for(int i=0;i<this.collection.length;i++) temp[i]=this.collection[i];
			this.collection=temp;
		}
		this.collection[this.size]=data;
		this.size++;
	}
	
	
	public void insert(int index,T data)
	{
		if(index<0 || index>size) throw new IndexOutOfBoundsException("Invalid Index : "+index);
		if(this.size==this.collection.length)
		{
			Object temp[]=new Object[this.size+10];
			for(int i=0;i<this.collection.length;i++) temp[i]=this.collection[i];
			this.collection=temp;
		}
		for(int i=this.size;i>index;i--)
		{
			this.collection[i]=this.collection[i-1];
		}
		this.collection[index]=data;
		this.size++;
	}
	
	public T removeAt(int index)
	{
		if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
		T data=(T)this.collection[index];
		for(int i=index;i<this.size-1;i++)
		{
			this.collection[i]=this.collection[i+1];
		}
		this.size--;
		return data;
	}
	
	public T get(int index)
	{
		if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
		return (T)this.collection[index]; 
	}
	
	public int size()
	{
		return this.size;
	}
	
	public void clear()
	{
		this.size=0;
	}
	
	
	public void add(int index,T data)
	{
		if(index<0 || index>size) throw new IndexOutOfBoundsException("Invalid Index : "+index);
		if(this.size==this.collection.length)
		{
			Object temp[]=new Object[this.size+10];
			for(int i=0;i<this.collection.length;i++) temp[i]=this.collection[i];
			this.collection=temp;
		}
		for(int i=this.size;i>index;i--)
		{
			this.collection[i]=this.collection[i-1];
		}
		this.collection[index]=data;
		this.size++;
	}

	
	public void removeAll()
	{
		clear();
	}
	
	public void update(int index,T data)
	{
		if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid Index : "+index);
		this.collection[index]=data;
	}

	public void copyTo(TMList<T> other)
	{
		other.clear();
		for(int i=0;i<this.size();i++) other.add(this.get(i));
		
	}
	public void copyFrom(TMList<T> other)
	{
		this.clear();
		for(int i=0;i<other.size();i++) this.add(other.get(i));
	}

	public void appendTo(TMList<T> other)
	{
		for(int i=0;i<this.size();i++) other.add(this.get(i));
	}
    
	public void appendFrom(TMList<T> other)
	{
		for(int i=0;i<other.size();i++) this.add(other.get(i));
	}
	
}

/*
 * collection length 10 -- 10 ele 
 * 10 ele got inserted capacity =0
 * creata atemp array 
 */
