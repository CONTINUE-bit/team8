
/**
 * App 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class App
{
public static void main(String[] args) {
    LibraryManagementSystem lms = new LibraryManagementSystem();
    
    lms.setUserDB("UserData2025.txt");
    System.out.println("-----이용자 목록-----");
    
    lms.setBookDB("BookData2025.txt");
    System.out.println("-----도서 목록-----");
    
}
}