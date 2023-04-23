package com.stopping.service.impl;

import com.stopping.pojo.entity.Tag;
import com.stopping.dao.mapper.test.TagMapper;
import com.stopping.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 多选标签表 服务实现类
 * </p>
 *
 * @author ideamake
 * @date 2023-04-08
 */
@Service
@Slf4j
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Resource
    private TagServiceImpl tagService;

    /**
     * 验证事务的传播性
     * @param tag
     */
    @Override
    public void saveTag(Tag tag) {
        log.info("保存标签:{}", tag.toString());
        tagService.saveMethod(tag);
    }


    @Transactional(rollbackFor = Exception.class)
    public void saveMethod(Tag tag){
        this.save(tag);
        log.info("保存已完成");
        throw new RuntimeException("save tag exception");
    }
}
