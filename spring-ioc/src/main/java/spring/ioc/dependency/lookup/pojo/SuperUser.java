package spring.ioc.dependency.lookup.pojo;

import lombok.Data;
import spring.ioc.dependency.lookup.annotation.Super;

/**
 * 超级用户
 */
@Super
@Data
public class SuperUser extends User{
    private String address;
}
