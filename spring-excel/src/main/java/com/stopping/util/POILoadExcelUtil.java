package com.stopping.util;

import com.alibaba.excel.util.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @Classname: POILoadExcelUtil
 * @Date: 2023/3/29 4:48 下午
 * @author: stopping
 */
public class POILoadExcelUtil {

    public static void main(String[] args) {
        alterTable("/Users/stopping/stopping/spring-integrate/spring-excel/src/main/resources/yx-money.xlsx"," im_marketing_payment "," ADD COLUMN ");
    }


    public static void createTable(String excelFilePath,String tableName){

    }

    public static void alterTable(String excelFilePath,String tableName,String operation) {
        boolean isHeader = true;
        StringBuilder stringBuilder = new StringBuilder();
        // Load the Excel file
        File file = new File(excelFilePath);
        FileInputStream inputStream = null;
        Workbook workbook = null;
        try {
            inputStream = new FileInputStream(file);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Get the first sheet in the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Iterate over the rows in the sheet
        for (Row row : sheet) {
            if (isHeader){
                isHeader = false;
            }else{
                stringBuilder.append("ALTER TABLE ").append(tableName).append(operation);
            }
            // Iterate over the cells in the row
            int n = 4;
            for (int i = 0; i < n; i++) {
                 String stringCellValue = Objects.isNull(row.getCell(i)) ? "" : row.getCell(i).getStringCellValue();
                 switch (i){
                     //字段名称
                     case 0:
                         stringBuilder.append(stringCellValue+" ");
                         break;
                     //类型
                     case 1:
                        String type = stringCellValue.contains("VARCHAR") ? stringCellValue+" COLLATE utf8mb4_unicode_ci" : stringCellValue;
                        stringBuilder.append(" "+type);
                        break;
                     //类型
                     case 2:
                         stringBuilder.append(stringCellValue.equals("是")? " NOT NULL" : " ");
                         break;
                     // 备注
                     case 3:
                         stringBuilder.append(" COMMENT '"+stringCellValue+"'").append(";\n");
                         break;
                     default:
                         break;
                 }
            }
        }
        System.out.println(stringBuilder.toString());
        // Close the workbook and input stream
        try {
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
