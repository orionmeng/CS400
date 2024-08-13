/*
 * This class tests the functionality of SearchFrontEnd.java
 * @author Orion Meng
 */
public class SearchFrontEndTests {
  
  /*
   * Tests if a song is inserted upon user input.
   * @return true if test passed
   */
  public static boolean FrontEndDeveloper_testInsert() {
    TextUITester text = new TextUITester("i\nHello\nWorld\n1950\nq\n");
    SearchFrontEnd frontEnd = new SearchFrontEnd();
    SearchBackEndInterface backEnd = new SearchBackEnd();
    frontEnd.run(backEnd);
    String output = text.checkOutput();
    if(output.startsWith("Please choose an option:") && 
       output.contains("Song inserted."))
        return true;
    else
        return false;
  }
  
  /*
   * Tests if a song can be found from a given title.
   * @return true if test passed
   */
  public static boolean FrontEndDeveloper_testTitle() {
    TextUITester text = new TextUITester("t\nHello\nq\n");
    SearchFrontEnd frontEnd = new SearchFrontEnd();
    SearchBackEndInterface backEnd = new SearchBackEnd();
    SongData song = new SongData("Hello", "World", 1950);
    backEnd.addSong(song);
    frontEnd.run(backEnd);
    String output = text.checkOutput();
    if(output.startsWith("Please choose an option:") && 
       output.contains("Hello"))
        return true;
    else
        return false;
  }
  
  /*
   * Tests if an artist can be found from a given title.
   * @return true if test passed
   */
  public static boolean FrontEndDeveloper_testArtist() {
    TextUITester text = new TextUITester("a\nHello\nq\n");
    SearchFrontEnd frontEnd = new SearchFrontEnd();
    SearchBackEndInterface backEnd = new SearchBackEnd();
    SongData song = new SongData("Hello", "World", 1950);
    backEnd.addSong(song);
    frontEnd.run(backEnd);
    String output = text.checkOutput();
    if(output.startsWith("Please choose an option:") && 
       output.contains("World"))
        return true;
    else
        return false;
  }
  
  /*
   * Tests if a histogram is created.
   * @return true if test passed
   */
  public static boolean FrontEndDeveloper_testHistogram() {
    TextUITester text = new TextUITester("y\nHello\nq\n");
    SearchFrontEnd frontEnd = new SearchFrontEnd();
    SearchBackEndInterface backEnd = new SearchBackEnd();
    SongData song = new SongData("Hello", "World", 1950);
    backEnd.addSong(song);
    frontEnd.run(backEnd);
    String output = text.checkOutput();
    if(output.startsWith("Please choose an option:") && 
       output.contains("1950 |#"))
        return true;
    else
        return false;
  }
  
  /*
   * Runs all test methods.
   */
  public static void main(String[] args) {
    System.out.println(FrontEndDeveloper_testInsert());
    System.out.println(FrontEndDeveloper_testTitle());
    System.out.println(FrontEndDeveloper_testArtist());
    System.out.println(FrontEndDeveloper_testHistogram());
  }
}
