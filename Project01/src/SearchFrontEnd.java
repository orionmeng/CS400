import java.util.List;
import java.util.Scanner;

/*
 * Interface for front end development.
 * @param searchEngine the search engine to be used
 * @author Orion Meng
 */
interface SearchFrontEndInterface {    
    public void run(SearchBackEndInterface searchEngine);
    // Here is a sample of the minimal set of options that 
    // this front end will support:
    // SongSearch Command Menu:
    // 1. Insert New Song into Database
    // 2. Search For Song Titles by Words in those Title
    // 3. Search For Artists by Words in their Song Titles
    // 4. Display Years of Songs with Word in Title as Histogram
    // 5. Quit
}

/*
 * This class creates the front end of the program.
 */
public class SearchFrontEnd implements SearchFrontEndInterface {
    @Override
    public void run(SearchBackEndInterface searchEngine) {
      Scanner userInput = new Scanner(System.in);
      boolean prompt = true;
      do {
        System.out.println("Please choose an option:");
        System.out.println("Insert a song                                   (i), ");
        System.out.println("search for song titles with a keyword/s         (t), ");
        System.out.println("search for songs of artists with a keyword/s    (a), ");
        System.out.println("display years of songs with a keyword/s         (y), ");
        System.out.println("or quit                                         (q).");
        String nextUserInput = userInput.nextLine();
        // insert a song
        if (nextUserInput.equals("i")) {
          System.out.println("Please enter the title of the song.");
          String title = "";
          boolean getTitle = true;
          do {
            title = userInput.nextLine();
            if (title.length() == 0 || title == null) {
              System.out.println("Invalid title; please try again.");
            } else {
              getTitle = false;
            }
          } while (getTitle);
          System.out.println("Please enter the artist of the song.");
          String artist = "";
          boolean getArtist = true;
          do {
            artist = userInput.nextLine();
            if (artist.length() == 0 || artist == null) {
              System.out.println("Invalid artist; please try again.");
            } else {
              getArtist = false;
            }
          } while (getArtist);
          System.out.println("Please enter the year of the song.");
          int year = 0;
          boolean getYear = true;
          do {
            if (!userInput.hasNextInt()) {
              System.out.println("Input a year.");
              userInput.nextLine();
              continue;
            }
            year = userInput.nextInt();
            userInput.nextLine();
            if (year < 0) {
              System.out.println("Invalid year; please try again.");
            } else {
              getYear = false;
            }
          } while (getYear);
          SongData song = new SongData(title, artist, year);
          searchEngine.addSong(song);
          System.out.println("Song inserted.");
        }
        // search for song titles with a keyword/s
        else if (nextUserInput.equals("t")) {
          System.out.println("Type in a keyword/s.");
          List<String> list = searchEngine.findTitles(userInput.nextLine());
          if (list.size() == 0) {
            System.out.println("No results.");
          } else {
            System.out.println("Here are the results:");
            for (int i = 0; i < list.size(); i++) {
              System.out.println(list.get(i));
            }
          }
        }
        // search for songs of artists with a keyword/s
        else if (nextUserInput.equals("a")) {
          System.out.println("Type in a keyword/s.");
          List<String> list = searchEngine.findArtists(userInput.nextLine());
          if (list.size() == 0) {
            System.out.println("No results.");
          } else {
            System.out.println("Here are the results:");
            for (int i = 0; i < list.size(); i++) {
              System.out.println(list.get(i));
            }
          }
        }
        // create histogram
        else if (nextUserInput.equals("y")) {
          System.out.println("Type in a keyword/s.");
          String titleWord = userInput.nextLine();
          int[] values = new int[120];
          for (int i = 0; i < values.length; i++) {
            values[i] = searchEngine.findNumberOfSongsInYear(titleWord, 1900 + i);
          }
          System.out.println("Histogram of Songs Containing the word " + titleWord + ".");
          for (int i = 0; i < values.length; i++) {
            System.out.print(1900 + i);
            System.out.print(" |");
            if (values[i] != 0) {
              for (int j = 0; j < values[i]; j++) {
                System.out.print("#");
              }
            }
            System.out.println("");
          }
          System.out.println("Note: each # represents a song.");
        }
        // quit
        else if (nextUserInput.equals("q")) {
          System.out.println("Goodbye!");
          prompt = false;
        }
        else {
          System.out.println("Invalid input; please try again.");
        }
      } while (prompt);
      userInput.close();
    }
}

/*
 * Placeholder.
 */
class SearchFrontEndPlaceholder implements SearchFrontEndInterface {
    public void run(SearchBackEndInterface searchEngine) {
        System.out.println("This front end has not been implemented yet.");
    }
}
