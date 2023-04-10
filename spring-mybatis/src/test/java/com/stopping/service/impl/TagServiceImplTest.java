package com.stopping.service.impl;

import com.stopping.pojo.entity.Tag;
import com.stopping.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Classname: TagServiceImplTest
 * @Description: TODO
 * @Date: 2023/4/8 11:03 上午
 * @author: stopping
 */
@SpringBootTest
class TagServiceImplTest {
    @Resource
    private TagService tagService;

    @Test
    void saveTag() {
        Tag tag = new Tag();
        tag.setGroupCode("zhjt");
        tag.setKey("t");
        tag.setValue("1");
        tag.setStatus(0);
        tagService.saveTag(tag);

    }
}