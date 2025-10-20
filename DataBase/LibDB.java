package DataBase;
import java.util.*;
import MyClass.*;

/**
 * 제네릭한 DB를 제공하는 LibDB클래스
 *
 * @author (2024320007 정회서)
 * @version (2025.10.20)
 */
public class LibDB<T extends DB_Element>
{
    private ArrayList<T> db; // 인스턴스 변수

    /**
     * 비어 있는 DB를 생성하는 생성자
     */
    public LibDB()
    {
        db = new ArrayList<T>();
    }

    /**
     * DB에 요소를 추가하는 메소드
     *
     * @param  e  추가할 요소
     */
    public void addElement(T e){
        db.add(e);
    }

    /**
     * 주어진 ID와 일치하는 요소를 찾아 반환하는 메소드
     *
     * @param  s  찾아야 하는 ID
     * @return    일치하면 요소를 반환, 불일치는 null을 반환
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
    
    /**
     * DB에 저장된 모든 요소들을 한 줄씩 출력하는 메소드
     */
    public void printAllElements(){
        for(T e : db){
            System.out.println(e);
        }
    }
}
