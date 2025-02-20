package com.ruoyi.iot.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.iot.model.IdAndName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.iot.mapper.CategoryMapper;
import com.ruoyi.iot.domain.Category;
import com.ruoyi.iot.service.ICategoryService;

import static com.ruoyi.common.utils.SecurityUtils.getLoginUser;

/**
 * 产品分类Service业务层处理
 * 
 * @author kerwincui
 * @date 2021-12-16
 */
@Service
public class CategoryServiceImpl implements ICategoryService 
{
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询产品分类
     * 
     * @param categoryId 产品分类主键
     * @return 产品分类
     */
    @Override
    public Category selectCategoryByCategoryId(Long categoryId)
    {
        return categoryMapper.selectCategoryByCategoryId(categoryId);
    }

    /**
     * 查询产品分类列表
     * 
     * @param category 产品分类
     * @return 产品分类
     */
    @Override
    public List<Category> selectCategoryList(Category category)
    {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 查询产品分简短类列表
     *
     * @return 产品分类
     */
    @Override
    public List<IdAndName> selectCategoryShortList()
    {
        return categoryMapper.selectCategoryShortList();
    }

    /**
     * 新增产品分类
     * 
     * @param category 产品分类
     * @return 结果
     */
    @Override
    public int insertCategory(Category category)
    {
        SysUser user = getLoginUser().getUser();
        List<SysRole> roles=user.getRoles();
        if(roles==null || roles.size()==0) {return 0;}
        // 系统管理员
        if(roles.stream().anyMatch(a->a.getRoleKey().equals("admin"))){
            category.setIsSys(1);
        }
        category.setTenantId(user.getUserId());
        category.setTenantName(user.getUserName());
        category.setCreateTime(DateUtils.getNowDate());
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改产品分类
     * 
     * @param category 产品分类
     * @return 结果
     */
    @Override
    public int updateCategory(Category category)
    {
        category.setUpdateTime(DateUtils.getNowDate());
        return categoryMapper.updateCategory(category);
    }

    /**
     * 批量删除产品分类
     * 
     * @param categoryIds 需要删除的产品分类主键
     * @return 结果
     */
    @Override
    public int deleteCategoryByCategoryIds(Long[] categoryIds)
    {
        return categoryMapper.deleteCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除产品分类信息
     * 
     * @param categoryId 产品分类主键
     * @return 结果
     */
    @Override
    public int deleteCategoryByCategoryId(Long categoryId)
    {
        return categoryMapper.deleteCategoryByCategoryId(categoryId);
    }
}
