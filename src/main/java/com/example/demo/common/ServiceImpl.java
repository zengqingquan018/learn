/*
package com.example.demo.common;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

*/
/**
 * MyBatis 通用 Mapper
 *
 * @author zengqingquan
 * @date 2021/1/4
 *//*

public class ServiceImpl<M extends Mapper<T>, T> implements IService<T> {

    @Autowired
    protected M mapper;


    @Override
    public List<T> select(T record) {
        return this.mapper.select(record);
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public List<T> selectByIds(String ids) {
        return null;
    }

    @Override
    public T selectOne(T record) {
        return mapper.selectOne(record);
    }

    @Override
    public int selectCount(T record) {
        return mapper.selectCount(record);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insert(T record) {
        return retBool(mapper.insert(record));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertSelective(T record) {
        return retBool(mapper.insertSelective(record));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateByPrimaryKey(T record) {
        return retBool(mapper.updateByPrimaryKey(record));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateByPrimaryKeySelective(T record) {
        return retBool(mapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public int updateByExample(T record, Object condition) {
        return mapper.updateByExample(record, condition);
    }

    @Override
    public int updateByExampleSelective(T record, Object condition) {
        return mapper.updateByExampleSelective(record, condition);
    }

    @Override
    public boolean deleteByPrimaryKey(Object key) {
        return retBool(mapper.deleteByPrimaryKey(key));
    }


    @Override
    public boolean deleteBySeletive(T record) {
        return retBool(mapper.delete(record));
    }

    private boolean retBool(Integer result) {
        return null != result && result.intValue() >= 1;
    }
}
*/
