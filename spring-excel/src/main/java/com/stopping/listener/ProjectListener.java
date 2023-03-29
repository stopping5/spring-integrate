package com.stopping.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.stopping.an.ExcelNotNull;
import com.stopping.pojo.ProjectData;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.ehcache.impl.store.HashUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @Classname: ProjectListener
 * @Description: 项目
 * @Date: 2023/3/24 2:40 下午
 * @author: stopping
 */
@Slf4j
public class ProjectListener implements ReadListener<ProjectData> {

    private Integer type;

    public ProjectListener(Integer type) {
        this.type = type;
    }

    @SneakyThrows
    @Override
    public void invoke(ProjectData projectData, AnalysisContext analysisContext) {
        System.out.println("读取数据:"+ projectData.toString());

        Class<?> c = projectData.getClass();
        for (Field field : c.getDeclaredFields()){
            if (field.isAnnotationPresent(ExcelNotNull.class)){
                if (!field.isAccessible()){
                    field.setAccessible(true);
                }
                System.out.println("field.get(projectData)"+(String) field.get(projectData));
            }
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("doAfterAllAnalysed,type:"+type);
    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        System.out.println("读取表头信息.."+ JSON.toJSONString(headMap));

    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        System.out.println("extra:"+JSON.toJSONString(extra));
    }


}
