//--== CS400 Project One File Header ==--
//Name: Orion Meng
//Email: dmeng8@wisc.edu
//Team: BLUE
//Group: CC
//TA: Abhinav (agarwal72@cs.wisc.edu)
//Lecturer: Florian Heimerl
//Notes to Grader: N/A

/*
 * This class tests the functionality of HashtableMap.
 */
class HashtableMapTests {
  
  /*
   * Tests HashtableMap.put().
   */
  public static boolean testPut() {
    HashtableMap test = new HashtableMap(10);
    if (test.put(9, 9)) {
      return true;
    }
    test.put(1, 1);
    test.put(2, 2);
    test.put(3, 3);
    test.put(4, 4);
    test.put(5, 5);
    test.put(6, 6);
    test.put(7, 7);
    test.put(8, 8);
    return false;
  }

  /*
   * Tests HashtableMap.get().
   */
  public static boolean testGet() {
    HashtableMap test = new HashtableMap(10);
    test.put(13, 103);
    test.put('a', 102);
    test.put("hello", 101);
    if (test.get(13) != (Object) 103) {
      return false;
    }
    if (test.get('a') != (Object) 102) {
      return false;
    }
    if (test.get("hello") != (Object) 101) {
      return false;
    }
    return true;
  }

  /*
   * Tests HashtableMap.size().
   */
  public static boolean testSize() {
    HashtableMap test = new HashtableMap(10);
    if (test.size() != 0) {
      return false;
    }
    test.put(13, 103);
    test.put(12, 102);
    if (test.size() != 2) {
      return false;
    }
    test.put(12, 102);
    if (test.size() != 2) {
      return false;
    }
    test.clear();
    if (test.size() != 0) {
      return false;
    }
    return true;
  }

  /*
   * Tests HashtableMap.contains().
   */
  public static boolean testContains() {
    HashtableMap test = new HashtableMap(10);
    test.put(1, 1);
    if (!test.containsKey(1)) {
      return false;
    }
    if (test.containsKey(2)) {
      return false;
    }
    return true;
  }

  /*
   * Tests HashtableMap.remove().
   */
  public static boolean testRemove() {
    HashtableMap test = new HashtableMap(10);
    test.put(13, 103);
    test.put('a', 102);
    test.put("hello", 101);
    if (test.remove("hello") != (Object) 101) {
      return false;
    }
    if (test.size() != 2) {
      return false;
    }
    return true;
  }

  /*
   * Tests HashtableMap.clear().
   */
  public static boolean testClear() {
    HashtableMap test = new HashtableMap(10);
    test.put(13, 103);
    test.put(12, 102);
    test.put(11, 101);
    test.clear();
    if (test.size() != 0) {
      return false;
    }
    return true;
  }

  /*
   * Runs all tests individually.
   */
  public static void main(String args[]) {
    System.out.println("testPut(): " + testPut());
    System.out.println("testGet(): " + testGet());
    System.out.println("testSize(): " + testSize());
    System.out.println("testContains(): " + testContains());
    System.out.println("testRemove(): " + testRemove());
    System.out.println("testClear(): " + testClear());
  }
  
}
