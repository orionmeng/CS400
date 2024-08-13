//--== CS400 Project One File Header ==--
//Name: Orion Meng
//Email: dmeng8@wisc.edu
//Team: BLUE
//Group: CC
//TA: Abhinav (agarwal72@cs.wisc.edu)
//Lecturer: Florian Heimerl
//Notes to Grader: N/A

import java.util.NoSuchElementException;
import java.util.LinkedList;

/*
 * This class is HashtableMap which implements MapADT.
 */
class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  
  private LinkedList<Pair>[] list; // instance array of linked lists
  private int size; // number of pairs in current instance array
  
  /*
   * This class creates a Pair of key and value.
   */
  class Pair {
    
    Object key; // key for value
    Object val; // value of key
    
    /*
     * Constructor for Pair.
     * @param pairKey key of pair
     * @param pairVal value of pair
     */
    Pair(Object pairKey, Object pairVal) {
      key = pairKey;
      val = pairVal;
    }
    
  }
  
  /*
   * Constructor for HashtableMap.
   * Default capacity is 20.
   * If given invalid capacity (negative or 0) then capacity is set to the default.
   * @param capacity capacity of instance array
   */
  public HashtableMap(int capacity) {
    // invalid capacity default to 20
    if (capacity <= 0) {
      list = new LinkedList[20];
    }
    else {
      list = new LinkedList[capacity];
    }
    for (int i = 0; i < list.length; ++i) {
      list[i] = new LinkedList<Pair>();
    }
    size = 0;
  }
  
  /*
   * Constructor for HashtableMap.
   * Default capacity is 20.
   */
  public HashtableMap() {
    list = new LinkedList[20];
    for (int i = 0; i < list.length; ++i) {
      list[i] = new LinkedList<Pair>();
    }
    size = 0;
  }
  
  /*
   * Inserts a Pair into the instance array.
   * @param key key of pair
   * @param value value of pair
   * @return true if successful and false otherwise
   */
  @Override
  public boolean put(Object key, Object value) {
    int capacity = list.length;
    double numLoad = size;
    double denLoad = list.length;
    // return false for null values
    if (key == null || value == null) {
      return false;
    }
    // return false if key already exists
    if (containsKey(key)) {
      return false;
    }
    int index = (Math.abs(key.hashCode()) % list.length);
    // return false if out of bounds
    if (index >= list.length) {
      return false;
    }
    // check load
    if (numLoad/denLoad >= 0.8) {
      LinkedList[] temp = new LinkedList[capacity];
      for (int i = 0; i < list.length; ++i) {
        temp[i] = new LinkedList<Pair>();
      }
      for (int i = 0; i < capacity; ++i) {
        temp[i] = list[i];
      }
      list = new LinkedList[capacity * 2];
      for (int i = 0; i < list.length; ++i) {
        list[i] = new LinkedList<Pair>();
      }
      for (int i = 0; i < capacity; ++i) {
        list[i % capacity] = temp[i];
      }
    }
    // add value at key
    list[index].add(new Pair(key, value));
    ++size;
    // check load again
    capacity = list.length;
    numLoad = size;
    denLoad = list.length;
    if (numLoad/denLoad >= 0.8) {
      LinkedList<Pair>[] temp = new LinkedList[capacity];
      for (int i = 0; i < list.length; ++i) {
        temp[i] = new LinkedList<Pair>();
      }
      for (int i = 0; i < capacity; ++i) {
        temp[i] = list[i];
      }
      list = new LinkedList[capacity * 2];
      for (int i = 0; i < list.length; ++i) {
        list[i] = new LinkedList<Pair>();
      }
      for (int i = 0; i < capacity; ++i) {
        list[i % capacity] = temp[i];
      }
    }
    return true; // added value to list
  }
  
  /*
   * Retrieves value from given key.
   * @param key key to search with.
   * @return value paired with given key.
   * @throws NoSuchElementException if key does not exist.
   */
  @Override
  public Object get(Object key) throws NoSuchElementException {
    int index = (Math.abs(key.hashCode()) % list.length);
    if (containsKey(key)) {
      for (int i = 0; i < list[index].size(); ++i) {
        if (list[index].get(i).key == key) {
          return list[index].get(i).val;
        }
      }
    }
    throw new NoSuchElementException("key does not exist");
  }
  
  /*
   * Returns current number of values.
   * @return current number of values.
   */
  @Override
  public int size() {
    return size;
  }
  
  /*
   * Determines whether the given key exists.
   * @param key key to be searched for.
   * @return true if key exists and false otherwise.
   */
  @Override
  public boolean containsKey(Object key) {
    int index = (Math.abs(key.hashCode()) % list.length);
    // return false if out of bounds
    if (index >= list.length) {
      return false;
    }
    if (list[index].size() == 0) {
      return false;
    }
    // return true if key exists
    for (int i = 0; i < list[index].size(); ++i) {
      if (list[index].get(i).key == key) {
        return true;
      }
    }
    return false;
  }
  
  /*
   * Removes the pair given by the key.
   * @param key key of the pair to be removed.
   * @return value of the pair that was removed.
   */
  @Override
  public Object remove(Object key) {
    int index = (Math.abs(key.hashCode()) % list.length);
    // return null if key does not exist
    if (!containsKey(key)) {
      return null;
    }
    Object removed;
    for (int i = 0; i < list[index].size(); ++i) {
      if (list[index].get(i).key == key) {
        removed = list[index].get(i).val;
        list[index].remove(i);
        --size;
        return removed;
      }
    }
    return null;
  }
  
  /*
   * Clears the instance array of all values.
   */
  @Override
  public void clear() {
    for (int i = 0; i < list.length; ++i) {
      for (int j = 0; j < list[i].size(); ++j) {
        list[i].remove(j);
      }
    }
    size = 0;
  }
  
}
