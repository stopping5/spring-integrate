package com.stopping.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.stopping.listener.ProjectListener;
import com.stopping.pojo.ProjectData;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @Classname: Excel Analysis 分析
 * @Date: 2023/3/24 9:43 上午
 * @author: stopping
 */@Slf4j
public class ExcelAnalysis {
    public void read(){
        EasyExcel.read(new File("/Users/stopping/stopping/spring-integrate/spring-excel/src/main/resources/test.xlsx"), ProjectData.class,new PageReadListener<ProjectData>(
            projectData -> {
                for (ProjectData p : projectData){
                    System.out.println("读取数据:"+ p.toString());
                }
            }
        )).sheet().doRead();
    }

    public void readByListener(){
        EasyExcel.read(new File("/Users/stopping/stopping/spring-integrate/spring-excel/src/main/resources/test.xlsx"),
                ProjectData.class,
                new ProjectListener(1)
        ).sheet().doRead();
    }

    public static void main(String[] args) {
        ExcelAnalysis excelAnalysis = new ExcelAnalysis();
        excelAnalysis.readByListener();
    }
}
