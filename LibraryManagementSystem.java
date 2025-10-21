import MyClass.*;
import DataBase.*;
import java.io.*;
import java.util.*;

/**
 * 책, 이용자, 대출 DB를 처리하는 클래스
 *
 * @author (2022320036 유재윤)
 * @version (2025.10.20)
 */
public class LibraryManagementSystem{
    private LibDB<Book> bookDB;
    private LibDB<User> userDB;
    private HashMap<User, Book> loanDB;

    /**
     *  내부 데이터가 비어있는 책, 이용자, 대출 DB를 생성하는 생성자
     */
    public LibraryManagementSystem(){
        this.bookDB = new LibDB<Book>();
        this.userDB = new LibDB<User>();
        this.loanDB = new HashMap<User, Book>();
    }

    /**
     * 이용자와 책의 ID를 대출에 정보를 등록하는 메소드
     *
     *  @param  userID  이용자ID
     *  @param  bookID  책ID
     */
    public void borrowBook(String userID, String bookID){
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        loanDB.put(user, book);
    }

    /**
     * DB의 모든 요소를 출력하는 메소드
     *
     *  @param  db    출력할 DB
     *  @param  <T>   DB의 요소 타입
     */
    public <T extends DB_Element> void printDB(LibDB<T> db){
        db.printAllElements();
    }

    /**
     *  대출 현황을 한 줄씩 출력하는 메소드
     */
    public void printLoanList(){
        Iterator<User> it = loanDB.keySet().iterator();
        while (it.hasNext()){
            User u = it.next();
            Book b = loanDB.get(u);
            System.out.println(u.toString() + " ===> " + b.toString());
        }
    }

    /**
     * 파일에서 책의 정보를 읽어들이고 책DB에 추가하는 메소드
     *
     *  @param  bookFile  파일의 입력 경로
     *  @return    추가된 책DB 반환
     */
    public LibDB<Book> setBookDB(String bookFile){
        try{
            FileReader fr = new FileReader(bookFile);
            Scanner sc = new Scanner(fr);
            ArrayList<String> lines = new ArrayList<String>();

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(!line.equals(""))
                    lines.add(line);
            }

            Iterator<String> it = lines.iterator();
            while (it.hasNext()){
                StringTokenizer st = new StringTokenizer(it.next(), "/");
                Book book = new Book(
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),
                        st.nextToken(),               
                        Integer.parseInt(st.nextToken())
                    );
                bookDB.addElement(book);
            }
            
            sc.close();
            fr.close();
        }
        catch(IOException e){
            System.out.println("Book 파일을 읽을 수 없습니다.");
        }
        catch(Exception e){
            System.out.println("Book을 처리하는 중 오류가 발생했습니다.");
        }

        return bookDB;
    }

    /**
     * 파일에서 이용자의 정보를 읽어들이고 이용자DB에 추가하는 메소드
     *
     *  @param  path  파일의 입력 경로
     *  @return  추가된 이용자DB 반환
     */
    public LibDB<User> setUserDB(String path){
        try{
            FileReader fr = new FileReader(path);
            Scanner sc = new Scanner(fr);

            ArrayList<String> list = new ArrayList<String>();
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                if (!line.equals("")) list.add(line);
            }

            for (int i = 0; i < list.size(); i++){
                StringTokenizer st = new StringTokenizer(list.get(i), "/");
                User user = new User(Integer.parseInt(st.nextToken()), st.nextToken());
                userDB.addElement(user);
            }

            sc.close();
            fr.close();
        }
        catch (IOException e){
            System.out.println("User 파일을 읽을 수 없습니다.");
        }
        catch (Exception e){
            System.out.println("User를 처리하는 중 오류가 발생했습니다.");
        }

        return userDB;
    }
}
