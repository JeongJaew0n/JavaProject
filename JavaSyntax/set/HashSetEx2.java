package set;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx2 {
    public static void main(String[] args) {
        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(new Person("Steve",10));
        hashSet.add(new Person("Steve",10));
        hashSet.add(new Person("Steve",11));

        System.out.println(hashSet);
    }
}

class Person{
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj){
        if(obj instanceof Person){
            Person who = (Person) obj;
            return this.name.equals(who.name) && this.age == who.age;
        }
        return false;
    }

    /* equals 오버라이딩시 hashCode 도 같이 구현 하는 것이 원칙이지만
    *  굳이 구현안해도 ㄱㅊ
    *  */
//    public int hashCode(){
//        return Objects.hash(name,age);
//    }

    public String toString(){
        return "name " + name + ", age: " + age;
    }
}
