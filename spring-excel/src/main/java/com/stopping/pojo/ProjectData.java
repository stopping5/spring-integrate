package com.stopping.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.stopping.an.ExcelNotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * @Classname: ProjectData
 * @Date: 2023/3/24 9:51 上午
 * @author: stopping
 */
@Data
@EqualsAndHashCode
@ToString(includeFieldNames = false)
public class ProjectData {
    @ExcelProperty(index = 0)
    @ExcelNotNull
    private String index1;
    @ExcelProperty(index = 1)
    private String index2;
    @ExcelProperty(index = 2)
    private String index3;
}
