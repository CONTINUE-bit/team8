import MyClass.*;
import DataBase.*;
import java.io.*;
import java.util.*;

/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (작성자)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibraryManagementSystem{
    private LibDB<Book> bookDB;
    private LibDB<User> userDB;
    private HashMap<User, Book> loanDB;

    /**
     *  LibraryManagementSystem 클래스의 객체 생성자
     *
     */
    public LibraryManagementSystem(){
        this.bookDB = new LibDB<Book>();
        this.userDB = new LibDB<User>();
        this.loanDB = new HashMap<User, Book>();
    }

    /**
     * 예제 메소드 - 이 주석을 사용자의 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void borrowBook(String userID, String bookID){
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        loanDB.put(user, book);
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public static <T extends DB_Element> void printDB(LibDB<T> db)
    {
        db.printAllElements();
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void printLoanList() {
        Iterator<User> it = loanDB.keySet().iterator();
        while (it.hasNext()) {
            User u = it.next();
            Book b = loanDB.get(u);
            System.out.println(u.toString() + " ===> " + b.toString());
        }
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB<Book> setBookDB(String bookFile)
    {
        try {
            FileReader fr = new FileReader(bookFile);
            Scanner sc = new Scanner(fr);
            ArrayList<String> lines = new ArrayList<String>();

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(!line.equals(""))
                    lines.add(line);
            }

            Iterator<String> it = lines.iterator();
            while(it.hasNext()) {
                String record = it.next();
                String[] a = record.split("/");
                int year = Integer.parseInt(a[4]);
                
                Book book = new Book(a[2], a[0], a[3], a[1], year);
                bookDB.addElement(book);
            }
            sc.close();
            fr.close();
        } 
        catch(IOException e) {
            System.out.println("파일을 읽을 수 없습니다.");
        } 
        catch(Exception e) {
            System.out.println("데이터를 처리하는 중 오류가 발생했습니다.");
        }

        return bookDB;
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB<User> setUserDB(String path)
    {
        try{
            FileReader fr = new FileReader(path);
            Scanner sc = new Scanner(fr);

            ArrayList<String> list = new ArrayList<String>();
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                if (!line.equals("")) list.add(line);
            }

            // for문 사용 (요구사항)
            for (int i = 0; i < list.size(); i++){
                String rec = list.get(i);
                String[] a = rec.split("/");     // stID/name

                int id = Integer.parseInt(a[0]);
                String name = a[1];

                User user = new User(id, name);
                userDB.addElement(user);
            }

            sc.close();
            fr.close();
        } 
        catch (IOException e) {
            System.out.println("user 파일을 읽을 수 없습니다.");
        } 
        catch (Exception e) {
            System.out.println("user 처리 중 오류 발생");
        }

        return userDB;
    }

}
