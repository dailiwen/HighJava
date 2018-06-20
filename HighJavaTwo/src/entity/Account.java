package entity;

/**
 * 登录注册信息
 * @author dailiwen
 * @date 2018/05/29
 */
public class Account {
    private String id;
    private String name;
    private String password;

    public Account() {

    }

    public Account(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = System.currentTimeMillis() + "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
