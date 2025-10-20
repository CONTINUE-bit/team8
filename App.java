import MyClass.*;
import DataBase.*;
import java.io.*;
import java.util.*;

/**
 * App을 실행하는 클래스
 *
 * @author (2020310059 최승빈)
 * @version (2025.10.20)
 */
public class App {
    public static void main(String[] args) {
        // ① 시스템 객체 생성
        LibraryManagementSystem lms = new LibraryManagementSystem();
        
        // ② 이용자 DB 설정 및 출력
        LibDB<User> userDB = lms.setUserDB("C:\\Temp\\UserData2025.txt");
        System.out.println("----- 이용자 목록 -----");
        lms.printDB(userDB);

        // ③ 도서 DB 설정 및 출력
        LibDB<Book> bookDB = lms.setBookDB("C:\\Temp\\BookData2025.txt");
        System.out.println("----- 도서 목록 -----");
        lms.printDB(bookDB);

        // ④ 대출 작업 3건 수행
        lms.borrowBook("2025320001", "B02");
        lms.borrowBook("2024320002", "B03");
        lms.borrowBook("2023320003", "B04");

        // ⑤ 대출 현황 출력
        System.out.println("----- 대출 현황 -----");
        lms.printLoanList();
    }
}
