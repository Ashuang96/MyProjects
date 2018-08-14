package com.hand.service;

import com.hand.bean.ItemBean;
import com.hand.dao.ItemMapper;
import com.hand.model.Item;
import com.hand.utils.BeanValidator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ItemService {

    @Resource
    private ItemMapper itemMapper;

    public void addItem(ItemBean bean, String userId) {
        BeanValidator.check(bean);
        Item item = Item.builder()
                        .userId(Long.valueOf(userId))
                        .todoItemTitle(bean.getTodoItemTitle())
                        .todoItemContent(bean.getTodoItemContent())
                        .priority(bean.getPriority())
                        .creationDate(new Date())
                        .comments(bean.getComments())
                        .build();
        itemMapper.insertSelective(item);
    }

    public void deleteItem(Long id) {
        itemMapper.deleteByPrimaryKey(id);
    }

    public Item getItem(Long id) {
        Item item = itemMapper.selectByPrimaryKey(id);
        return item;
    }

    public List<Item> getItemListByUserId(Long id) {
        List<Item> itemList = itemMapper.getItemListByUserId(id);
        return itemList;
    }

    public void updateItem(Item item) {
        BeanValidator.check(item);
        item.setLastUpdateDate(new Date());
        itemMapper.updateByPrimaryKeySelective(item);
    }

    public void batchDelete(Long[] ids) {
        itemMapper.batchDeleteItem(ids);
    }
}
