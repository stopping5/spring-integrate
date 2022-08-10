# SpringBoot整合Mongo
> http://www.mydlq.club/article/85/
> https://www.springcloud.cc/spring-data-mongodb.html#mongodb-template-update
> https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo-template.upserts

## 整合MongoDB Repository
在SpringBoot整合MongoDB中不需要在MongoDB创建集合，在实体类插入数据后会自动生成集合。
如果需要更新字段，则在实体类更新，在插入数据之后会自动更新集合。
1. Application 启用配置
```aidl
@EnableMongoAuditing
```

2. 实体类映射
```java
package com.stopping.mongo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_info")
@Data
@Builder
public class UserInfo implements Serializable {
    @Id
    private String id;
    @Field("username")
    private String username;
    @Field("sex")
    private Integer sex;
    @Field("phone")
    private String phone;
    @Field("email")
    private String email;

    @CreatedDate
    @Field("created_at")
    protected LocalDateTime createdAt;

    @LastModifiedDate
    @Field("updated_at")
    protected LocalDateTime updatedAt;

    private Address address;

    /**
     * 预约签约地址
     */
    @Data
    public static class Address {
        /**
         * 地址名称
         */
        @Field("name")
        private String name;
        /**
         * 地址经度
         */
        @Field("longitude")
        private String longitude;
        /**
         * 地址纬度
         */
        @Field("latitude")
        private String latitude;
    }
}


```
3. 通过JPA实现自定义语句操作
```java
public interface UserInfoMapper extends MongoRepository<UserInfo,String> {
    /**
     * 查询UserInfo通过手机号
     * @param phone
     * @return
     */
    List<UserInfo> findAllByPhone(String phone);

    /**
     * 通过手机号删除
     * @param phone
     */
    void deleteUserInfoByPhone(String phone);


}
```