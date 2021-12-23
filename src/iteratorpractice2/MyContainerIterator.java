package iteratorpractice2;

public class MyContainerIterator implements Iterator{
	
	private int current = 0;
	private MyContainer container;
	
	public MyContainerIterator(MyContainer c) {
		container = c;
	}
	
	public boolean hasNext() {
		return current < container.size;
	}
	
	public Object next() {
		return container.items[current++];
	}
	

}
