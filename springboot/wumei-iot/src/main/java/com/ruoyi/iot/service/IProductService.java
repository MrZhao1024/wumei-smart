package com.ruoyi.iot.service;

import java.util.List;
import com.ruoyi.iot.domain.Product;
import com.ruoyi.iot.model.IdAndName;

/**
 * 产品Service接口
 * 
 * @author kerwincui
 * @date 2021-12-16
 */
public interface IProductService 
{
    /**
     * 查询产品
     * 
     * @param productId 产品主键
     * @return 产品
     */
    public Product selectProductByProductId(Long productId);

    /**
     * 查询产品列表
     * 
     * @param product 产品
     * @return 产品集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 查询产品简短列表
     *
     * @return 产品集合
     */
    public List<IdAndName> selectProductShortList();

    /**
     * 新增产品
     * 
     * @param product 产品
     * @return 结果
     */
    public Product insertProduct(Product product);

    /**
     * 修改产品
     * 
     * @param product 产品
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 批量删除产品
     * 
     * @param productIds 需要删除的产品主键集合
     * @return 结果
     */
    public int deleteProductByProductIds(Long[] productIds);

    /**
     * 删除产品信息
     * 
     * @param productId 产品主键
     * @return 结果
     */
    public int deleteProductByProductId(Long productId);
}
