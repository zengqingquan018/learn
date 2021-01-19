/*
package com.example.demo.common;

import java.util.List;

*/
/**
 * MyBatis 通用 Mapper
 *
 * @author zengqingquan
 * @date 2021/1/4
 *//*

public interface IService<T> {

    */
/**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param record
     * @return
     *//*

    List<T> select(T record);


    */
/**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key
     * @return
     *//*

    T selectByPrimaryKey(Object key);

    */
/**
     * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段
     *
     * @param ids
     * @return
     *//*

    List<T> selectByIds(String ids);

    */
/**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param record
     * @return
     *//*

    T selectOne(T record);

    */
/**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param record
     * @return
     *//*

    int selectCount(T record);

    */
/**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param record
     * @return
     *//*

    boolean insert(T record);

    */
/**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param record
     * @return
     *//*

    boolean insertSelective(T record);

    */
/**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param record
     * @return
     *//*

    boolean updateByPrimaryKey(T record);

    */
/**
     * 根据主键更新属性不为null的值
     *
     * @param record
     * @return
     *//*

    boolean updateByPrimaryKeySelective(T record);

    */
/**
     * 根据Example条件更新实体record包含的全部属性，null值会被更新
     *
     * @param record
     * @param condition
     * @return
     *//*

    int updateByExample(T record, Object condition);

    */
/**
     * 根据condition条件更新实体record包含的不是null的属性值
     *
     * @param record
     * @param condition
     * @return
     *//*

    int updateByExampleSelective(T record, Object condition);

    */
/**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key
     * @return
     *//*

    boolean deleteByPrimaryKey(Object key);

    */
/**
     * 根据条件全匹配删除
     *
     * @param record
     * @return boolean
     * @Author zhang.chao
     **//*

    boolean deleteBySeletive(T record);
}
*/
