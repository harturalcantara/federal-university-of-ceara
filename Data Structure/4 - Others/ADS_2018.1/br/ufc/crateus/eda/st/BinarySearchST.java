package br.ufc.crateus.eda.st;

import java.util.Arrays;

public class BinarySearchST <K extends Comparable <K>, V> implements OrderedST  <K, V>{
	
	private Object[] array;
	private int size;
	
	public BinarySearchST() {
		this(10);
	}
	
	public BinarySearchST(int length) {
		this.array = new Object[length];
		this.size = 0;
	}
	
	private class Entry {
		K key;
		V value;
		
		private Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	@Override
	public void put(K key, V value) {
		if (value == null) {
			delete(key);
			return;
		}
		
		if (size == array.length) {
			resize((3 * size) / 2);
		}
		
		int pos = rank(key);
		Entry entry = getEntry(pos);
		
		if (!key.equals(entry.key)) {
			for (int i = this.size(); i > pos; i--)
				array[i] = array[i - 1];
			
			array[pos] = new Entry(key, value);
			size++;
		}
		else {
			entry.value = value;
		}
	}
	
	private void resize(int newSize) {
		array = Arrays.copyOf(array, newSize);
	}
	
	@Override
	public int rank(K key) {
		int lo = 0; 
		int hi = this.size() - 1;
		
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			Entry midEntry = getEntry(mid);
			
			if (key.compareTo(midEntry.key) < 0) hi = mid - 1;
			else if (key.compareTo(midEntry.key) > 0) lo = mid + 1;
			else return mid;
		}
		
		return lo;
	}

	@Override
	public V get(K key) {
		int pos = rank(key);
		Entry entry = getEntry(pos);
		return (key.equals(entry.key))? entry.value : null;
	}

	@Override /** Okay */
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private Entry getEntry(int pos) {
		return (Entry) array[pos];	
	}

	@Override
	public K min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K floor(K e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K ceiling(K e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K select(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<K> keys(K lo, K hi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size(K lo, K hi) {
		// TODO Auto-generated method stub
		return 0;
}
	

}
