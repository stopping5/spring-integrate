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
import java.util.List;

/**
 * 中海签约预约规则配置文档
 *
 * @author chenjingpeng
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "im_zh_reserve_contract_rule_config")
public class ReserveContractRuleConfig implements Serializable {

    @Id
    protected String id;

    @Field("app_id")
    protected String appId;

    /**
     * 签约模式（1-城市签约中心签约、2-项目上签约）
     */
    @Field("mode")
    @Builder.Default
    private Integer mode = 1;

    /**
     * 行政城市id （im_area#id）
     */
    @Field("city_id")
    private Integer cityId;

    /**
     * 城市名称
     */
    @Field("city_name")
    private String cityName;

    /**
     * 是否开启预约0关1开
     */
    @Field("open_reserve")
    @Builder.Default
    private Integer openReserve = 1;

    /**
     * 可预约开始日期
     */
    @Field("reserve_date_begin")
    private String reserveDateBegin;

    /**
     * 可预约结束日期
     */
    @Field("reserve_date_end")
    private String reserveDateEnd;

    /**
     * 签约预约限制时段粒度（每半小时为1，半天即24）
     */
    @Field("reserve_time_interval_scale")
    private Integer reserveTimeIntervalScale = 1;

    /**
     * 签约预约时间区间（"08:00-10:00"）
     */
    @Field("reserve_time_interval")
    private List<String> reserveTimeInterval;

    /**
     * 不可签约预约时间区间（"08:00-10:00"）
     */
    @Field("um_reserve_time_interval")
    private List<String> unReserveTimeInterval;

    /**
     * 0接待量设置关闭、正整数打开
     */
    @Field("reserve_capacity")
    @Builder.Default
    private Integer reserveCapacity = 0;

    /**
     * 预约须知id
     */
    @Field("reserve_protocol_id")
    private Integer reserveProtocolId;

    /**
     * 预约签约地址
     */
    @Field("address")
    private Address address;

    /**
     * 购房资料
     */
    @Field("buy_building_data_list")
    private List<BuyBuildingData> buyBuildingDataList;

    /**
     * 付款资料
     */
    @Field("payment_data_list")
    private List<PaymentData> paymentDataList;

    @CreatedDate
    @Field("created_at")
    protected LocalDateTime createdAt;

    @LastModifiedDate
    @Field("updated_at")
    protected LocalDateTime updatedAt;

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

    /**
     * 购房资料
     */
    @Data
    public static class BuyBuildingData {

        /**
         * 业态 10-住宅 20-商业/办公 30-车位
         */
        @Field("building_type")
        private Integer buildingType = 10;

        /**
         * 0关1开
         */
        @Field("is_open")
        private Integer isOpen = 1;

        /**
         * 根据客户类型细分
         */
        @Field("customer_type_list")
        private List<CustomerType> customerTypeList;
    }

    /**
     * 购房资料#客户类型
     */
    @Data
    public static class CustomerType {

        /**
         * 客户类型 10-个人 20-公司
         */
        @Field("customer_type")
        private Integer customerType = 10;

        /**
         * 购房资料字段
         */
        @Field("field_list")
        private List<FieldInfo> fieldList;
    }

    /**
     * 资料字段
     */
    @Data
    public static class FieldInfo {

        /**
         * 资料名称
         */
        @Field("name")
        private String name;

        /**
         * 资料介绍
         */
        @Field("introduce")
        private String introduce;

        /**
         * 是否必填 1是、0否
         */
        @Field("required")
        private Integer required = 0;

        /**
         * 0关1开
         */
        @Field("is_open")
        private Integer isOpen = 1;

        /**
         * 是否是自定义字段 0: 默认字段 1.自定义字段
         */
        @Field("is_custom")
        private Integer isCustom = 0;
    }

    /**
     * 付款资料
     */
    @Data
    public static class PaymentData {

        /**
         * 付款方式 10-一次性付款 20-商业贷款 30-公积金贷款 40-组合贷款
         */
        @Field("payment_type")
        private Integer paymentType = 10;

        /**
         * 0关1开
         */
        @Field("is_open")
        private Integer isOpen = 1;

        /**
         * 付款资料字段
         */
        @Field("field_list")
        private List<FieldInfo> fieldList;
    }
}
