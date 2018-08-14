package com.hand.dao;

import com.hand.model.Item;

import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Long todoItemId);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long todoItemId);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> getItemListByUserId(Long id);

    void batchDeleteItem(Long[] ids);
}