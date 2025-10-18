package DataBase;
import java.util.*;
import MyClass.*;

/**
 * LibDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibDB<T extends DB_Element>
{
    // 인스턴스 변수 - 제네릭 타입 <T> 명시
    private ArrayList<T> db;

    /**
     * LibDB 클래스의 객체 생성자
     */
    public LibDB()
    {
        db = new ArrayList<T>();
    }

    public void addElement(T e){
        db.add(e);
    }
    
    /**
     * ID(String s)와 일치하는 요소를 찾아 반환합니다.
     * @param s 찾고자 하는 요소의 ID
     * @return T 일치하는 요소. 찾지 못하면 null 반환.
     */
    public T findElement(String s){
        Iterator<T> it = db.iterator();
        while(it.hasNext()){
            T element = it.next();
            if((element.getID()).equals(s)){
                return element;
            }
        }
        return null; 
    }
    
    public void printAllElements(){
        for(T e : db){
            System.out.println(e);
        }
    }
}
