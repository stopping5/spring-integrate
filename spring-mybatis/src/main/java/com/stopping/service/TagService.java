package com.stopping.service;

import com.stopping.pojo.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 多选标签表 服务类
 * </p>
 *
 * @author ideamake
 * @date 2023-04-08
 */
public interface TagService extends IService<Tag> {
    /**
     * 保存标签
     * @param tag
     */
    void saveTag(Tag tag);
}
