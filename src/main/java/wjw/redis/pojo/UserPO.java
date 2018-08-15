package wjw.redis.pojo;

import javax.print.DocFlavor;
import java.io.Serializable;

/**
 * @ClassName: UserPO
 * @Description: 用户对象
 * @version: v1.0.0
 * @author: wjw
 * @date: 2018/8/14 16:04
 */
public class UserPO {

    private Integer id;

    private String name;

    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
