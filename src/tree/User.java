package tree;

/**
 * Created by dengshaoxiang on 2020/1/3 14:20
 * description:
 */
public class User implements Comparable<User>{
    public int age;
    public String name;

    public User(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User o) {
        return age-o.age;
    }
}
