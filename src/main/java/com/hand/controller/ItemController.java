package com.hand.controller;

import com.hand.bean.ItemBean;
import com.hand.common.JsonData;
import com.hand.model.Item;
import com.hand.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Resource
    private ItemService itemService;

    @RequestMapping("/getItem/{id}")
    public String getItem(@PathVariable("id") String id, Map<String, Object> map) {
        Item item = itemService.getItem(Long.valueOf(id));
        map.put("item", item);
        return "article-edit";
    }

    @RequestMapping("/deleteItem/{id}")
    @ResponseBody
    public JsonData deleteItem(@PathVariable("id") String id) {
        itemService.deleteItem(Long.valueOf(id));
        return JsonData.success("删除成功");
    }

    @RequestMapping("/intoItemAdd/{userId}")
    public String intoItemAdd(@PathVariable("userId")String userId,Map<String, Object> map) {
        map.put("userId", userId);
        return "article-add";
    }

    @RequestMapping(value = "/addItem/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public JsonData addItem(ItemBean bean, @PathVariable("userId") String userId) {
        itemService.addItem(bean, userId);
        return JsonData.success(true);
    }

    @RequestMapping(value = "/updateItem",method = RequestMethod.POST)
    @ResponseBody
    public JsonData updateItem(Item bean) {
        itemService.updateItem(bean);
        return JsonData.success(true);
    }

    @RequestMapping("/getItemList/{id}")
    public String getItemList(@PathVariable("id") String id, Map<String, Object> map) {
        List<Item> itemList =  itemService.getItemListByUserId(Long.valueOf(id));
        map.put("itemList", itemList);
        map.put("size", itemList.size());
        map.put("userId", id);
        return "article-list";
    }

    @RequestMapping("/intoItemEdit/{todoItemId}")
    public String intoItemEdit(@PathVariable("todoItemId")String todoItemId, Map<String, Object> map) {
        Item item = itemService.getItem(Long.valueOf(todoItemId));
        map.put("todoItemId", todoItemId);
        map.put("item", item);
        return "article-edit";
    }

    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    @ResponseBody
    public JsonData batchDelete(Long[] IDs) {
        itemService.batchDelete(IDs);
        return JsonData.success(true);
    }
}
