package wjw.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import wjw.redis.pojo.UserPO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class RedisApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private RedisTemplate redisTemplate;

    /**
    * @Description: 操作String类型 set
    * @param:
    * @return 
    * @version: v1.0.0
    * @exception
    * @author: wjw
    * @date: 2018/8/14 15:44 
    */
    @Test
    public void set(){
        redisTemplate.opsForValue().set("test:set","testValue1");
    }

    /**
    * @Description: 获取所有key
    * @param:
    * @return 
    * @version: v1.0.0
    * @exception
    * @author: wjw
    * @date: 2018/8/14 15:44 
    */
    @Test
    public void getKeys(){
        Set<String> set = redisTemplate.keys("*");
        for (String str : set) {
            System.out.println(str);
        }
    }

    /**
    * @Description: 操作列表
    * @param:
    * @return 
    * @version: v1.0.0
    * @exception
    * @author: wjw
    * @date: 2018/8/14 15:45 
    */
    @Test
    public void list(){
        List<String> list1 = new ArrayList<>(10);
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        Long  result=  redisTemplate.opsForList().rightPush("list1",list1);
        System.out.println(result);
    }

    @Test
    public void getList(){
       List<String> result = (List<String>) redisTemplate.opsForList().rightPop("list1");
       if(null!=result && result.size()>0){
           for (int i =0 ;i<result.size();i++){
               System.out.println(result.get(i));
           }

       }
    }

    @Test
    public void setHash(){
        UserPO userPO = new UserPO();
        userPO.setId(2);
        userPO.setName("b");
        userPO.setSex(0);
        redisTemplate.opsForHash().put("student",userPO.getId()+"",userPO);
    }
}
