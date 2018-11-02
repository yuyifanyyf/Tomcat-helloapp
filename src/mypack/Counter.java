package mypack;

public class Counter {
	private int count;
	public Counter() {
		this(0);
	}
	
	public Counter(int count) {
		this.count = count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void add(int step) {
		this.count += step;
	}
}
