package com.stopping.controller;

import com.lark.oapi.Client;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.request.SelfBuiltTenantAccessTokenReq;
import com.lark.oapi.core.response.TenantAccessTokenResp;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.AppTableRecord;
import com.lark.oapi.service.bitable.v1.model.BatchCreateAppTableRecordReq;
import com.lark.oapi.service.bitable.v1.model.BatchCreateAppTableRecordReqBody;
import com.lark.oapi.service.bitable.v1.model.BatchCreateAppTableRecordResp;
import com.lark.oapi.service.bitable.v1.model.CreateAppTableRecordReq;
import com.lark.oapi.service.bitable.v1.model.CreateAppTableRecordResp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/hello")
public class HelloController {

    @GetMapping("/say")
    public String sayHello(@RequestParam("w") String hello){
        System.out.println("接收参数:"+hello);

        return "say" + hello;
    }

    public static void main(String[] args) throws Exception {
        testRecord();
    }

    public static void getTenantAccessTokenBySelfBuiltApp() throws Exception {
        String appId = "cli_a5cb5aa802b8d00c";
        String appSecret = "NR80fn2atclCRQIMMy1fqftiHHWUIKre";

        // 构建client
        Client client = Client.newBuilder(appId, appSecret)
                .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
                .logReqAtDebug(true)
                .build();

        // 发起请求
        TenantAccessTokenResp resp = client.ext().getTenantAccessTokenBySelfBuiltApp(
                SelfBuiltTenantAccessTokenReq.newBuilder()
                        .appSecret(appSecret)
                        .appId(appId)
                        .build());

        // 处理结果
        System.out.println(Jsons.DEFAULT.toJson(resp));
        System.out.println(resp.getRequestId());
    }


    public static void testRecords() throws Exception {
        // 构建client
        Client client = Client.newBuilder("cli_a5cb5aa802b8d00c", "NR80fn2atclCRQIMMy1fqftiHHWUIKre").build();

        AppTableRecord[] records = new AppTableRecord[1];
        Map<String,Object> field = new HashMap<>();
        field.put("文本","111");
        AppTableRecord appTableRecord = new AppTableRecord();
        appTableRecord.setFields(field);
        records[0] = appTableRecord;
        // 创建请求对象
        BatchCreateAppTableRecordReq req = BatchCreateAppTableRecordReq.newBuilder()
                .appToken("Q8UnbYLXIaRltCsklyVcmXqYn2d")
                .tableId("tblZ8uoX6JYVZ1DJ")
                .batchCreateAppTableRecordReqBody(BatchCreateAppTableRecordReqBody.newBuilder()
                        .records(records)
                        .build())
                .build();

        // 发起请求
        BatchCreateAppTableRecordResp resp = client.bitable().appTableRecord().batchCreate(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }


    public static void testRecord() throws Exception {
        // 构建client
        Client client = Client.newBuilder("cli_a5cb5aa802b8d00c", "NR80fn2atclCRQIMMy1fqftiHHWUIKre").build();
        Map<String,Object> field = new HashMap<>();
        field.put("文本","111");
        // 创建请求对象
        CreateAppTableRecordReq req = CreateAppTableRecordReq.newBuilder()
                .appToken("Q8UnbYLXIaRltCsklyVcmXqYn2d")
                .tableId("tblZ8uoX6JYVZ1DJ")
                .appTableRecord(AppTableRecord.newBuilder()
                        .fields(field)
                        .build())
                .build();

        // 发起请求
        CreateAppTableRecordResp resp = client.bitable().appTableRecord().create(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }

    @GetMapping("/exception")
    public String exception(int i){
        System.out.println("接收参数:"+ (2 / i));
        Integer result = i + 2;
        return "say" + i;
    }

    @PostMapping("/name")
    public Boolean save(String name){
        System.out.println("save:" + name);
        return true;
    }
}
