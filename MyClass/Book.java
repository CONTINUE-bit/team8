package MyClass;

/**
 * 책의 정보를 나타내는 Book클래스
 *
 * @author (2024320007 정회서)
 * @version (2025.10.20)
 */
public class Book extends DB_Element
{
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;
    
    /**
     *  Book 클래스의 객체 생성자
     *  
     *  @param  bookID    책의 등록번호
     *  @param  title     책의 제목
     *  @param  author    책의 저자
     *  @param  publisher 책의 출판사
     *  @param  year      책의 출판연도
     */
    public Book(String bookID, String title, String author, String publisher, int year){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }
    
    /**
     * 책의 등록번호를 반환하는 메소드
     *
     * @return    등록번호 반환
     */
    public String getID(){
        return this.bookID;
    }
    
    /**
     * 책의 정보를 toString 형태의 문자열로 반환하는 메소드
     *
     * @return    "(등록번호) 제목, 저자, 출판사, 출판연도" 형태로 반환
     */
    public String toString(){
        return "(" + bookID + ") "+ title + ", " + author + " , " + publisher +" , " + year;
    }
}
