public class TMLinkedList<T> implements TMList<T>
{
	class Node<T>
	{
		public T data;
		public Node<T> next;
		Node()
		{
			this.data=null;
			this.next=null;
		}
	}

    private Node<T> start,end;
	private int size;
	public TMLinkedList()
	{
		this.start=null;
		this.end=null;
		this.size=0;
	}
	public void add(T data)
	{
		Node<T> t=new Node();
		t.data=data;
		if(this.start==null)
		{
			this.start=t;
			this.end=t;
		}
		else
		{
			this.end.next=t;
			this.end=t;
		}
		this.size++;
	}
	public void add(int index,T data)
	{
		if(index<0) throw new IndexOutOfBoundsException("Invalid Index : -1");
		if(index>=this.size)
		{
			add(data);
			return;
		}
		Node<T> tmp=new Node<>();
		tmp.data=data;
		if(index==0)
		{
			tmp.next=this.start;
			this.start=tmp;
		}
		else
		{
			Node<T> prev=null,curr=this.start;
			int i=0;
			while(i<index)
			{
				prev=curr;
				curr=curr.next;
				i++;
			}
			prev.next=tmp;
			tmp.next=curr;
		}
		this.size++;
	}

	public void insert(int index,T data)
	{
		if(index<0) throw new IndexOutOfBoundsException("Invalid Index : -1");
		if(index>=this.size)
		{
			add(data);
			return;
		}
		Node<T> tmp=new Node<>();
		tmp.data=data;
		if(index==0)
		{
			tmp.next=this.start;
			this.start=tmp;
		}
		else
		{
			Node<T> prev=null,curr=this.start;
			int i=0;
			while(i<index)
			{
				prev=curr;
				curr=curr.next;
				i++;
			}
			prev.next=tmp;
			tmp.next=curr;
		}
		this.size++;
	}

	public void removeAll()
	{
		clear();
	}
	public T removeAt(int index)
	{
		if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid Index : "+index);
		T data;
		if(this.start==this.end)
		{
			data=this.start.data;
			clear();
			return data;
		}
		if(index==0)
		{
			data=this.start.data;
			this.start=this.start.next;
			this.size--;
			return data;
		}
		Node<T> prev=null,curr=this.start;
		int i=0;
		while(i<index)
		{
			prev=curr;
			curr=curr.next;
			i++;
		}
		data=curr.data;
		prev.next=curr.next;
		if(curr==this.end) this.end=prev;
		this.size--;
		return data;
	}
	public void clear()
	{
		this.size=0;
		this.start=null;
		this.end=null;
	}

	public int size()
	{
		return this.size;
	}
	public T get(int index)
	{
		if(index<0 ||index>=this.size) throw new IndexOutOfBoundsException("Invalid Index : "+index);
		int x=0;
		Node<T> curr=start;
		while(x<index)
		{
			curr=curr.next;
			x++;
		}
		return curr.data;
	}

	public void update(int index,T data)
	{
		if(index<0 ||index>=this.size) throw new IndexOutOfBoundsException("Invalid Index : "+index);
		if(index==0)
		{
			this.start.data=data;
			return;
		}
		if(index==this.size-1)
		{
			this.end.data=data;
			return;
		}
		Node<T> curr=this.start;
		int i=0;
		while(i<index)
		{
			curr=curr.next;
			i++;
		}
		curr.data=data;
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
		throw new RuntimeException("Not yet Implemented");
	}
	public void appendFrom(TMList<T> other)
	{
		throw new RuntimeException("Not yet Implemented");
	}
}