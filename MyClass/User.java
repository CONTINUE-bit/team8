package MyClass;

/**
 * User 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class User extends DB_Element {
    private Integer studentID;
    private String name;

    public User(Integer studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public String getID() {
        return studentID.toString();
    }

    public String toString() {
        return "[" + studentID +"]" + " / " + name;
    }
}