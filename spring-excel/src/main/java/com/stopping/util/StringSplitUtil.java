package com.stopping.util;

import com.alibaba.excel.util.StringUtils;

/**
 * @Classname: StringSplitUtil
 * @Description: TODO
 * @Date: 2023/3/30 11:24 上午
 * @author: stopping
 */
public class StringSplitUtil {

    public static void main(String[] args) {
        split("价格、位置、物业、精装、中海品牌、户型设计、商业配套、学校、未来环境、升值潜力","、");
    }

    public static void split(String s,String rex){
        String [] tag = s.split(rex);
        for (String s1 : tag){
            System.out.println(s1);
        }
    }
}
