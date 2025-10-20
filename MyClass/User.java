package MyClass;

/**
 * 도서관 이용자 정보를 나타내는 User클래스
 *
 * @author (2024320007 정회서)
 * @version (2025.10.20)
 */
public class User extends DB_Element {
    private Integer studentID;
    private String name;

    /**
     *  User 클래스의 객체 생성자
     *
     *  @param  studentID 이용자의 학번
     *  @param  name      이용자의 이름
     */
    public User(Integer studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    /**
     * 이용자의 학번을 toString 형태의 문자열로 반환하는 메소드
     *
     * @return    이용자의 학번 반환
     */
    public String getID() {
        return studentID.toString();
    }

    /**
     * 이용자의 학번과 이름을 toString 형태의 문자열로 반환하는 메소드
     *
     * @return    "학번 / 이름" 형태로 반환
     */
    public String toString() {
        return studentID + " / " + name;
    }
}
