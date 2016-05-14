
package project;

import java.util.ArrayList;

public class GenericStack<E> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();
	public int getSize() {
		return list.size();
		}
	public E peek() {
		return list.get(getSize() - 1);
		}
	public void push(E o) {
		list.add(o);
		}
	public E pop() {
		E o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
		}
	public void removeIndex(int i) {
		list.remove(i);
		}
	public E getIndex(int index) {
		return list.get(index);
		}
	
	public boolean isEmpty() {
		return list.isEmpty();
		}
	public String getString() 
	{
		String x=list.toString();
		return x;
	}
	@Override
	public String toString() {
		return "stack: " + list.toString();
		}
	}
