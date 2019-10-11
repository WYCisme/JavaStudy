package Proxy;

/**
 * @projectName: javaStudy
 * @className: PeopleImp
 * @author: WenYichong
 * @date: 2019/8/27-10:08
 * @description: 连我自己都不知道在写什么......
 */
public class PeopleImp implements People{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    private String name;
    private String hobby;
    public PeopleImp(String name,String hobby){
        this.name=name;
        this.hobby=hobby;
    }
    @Override
    public void show() {
        System.out.println("我叫"+this.getName()+",我喜欢"+this.getHobby());
    }
}
