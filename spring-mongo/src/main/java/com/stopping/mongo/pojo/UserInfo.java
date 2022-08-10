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

