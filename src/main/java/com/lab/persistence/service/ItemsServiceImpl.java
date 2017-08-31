package com.lab.persistence.service;

import com.lab.persistence.mapper.ItemsMapper;
import com.lab.persistence.model.ItemsModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemsService {
    
    @Autowired
    ItemsMapper itemsMapper;

    @Override
    public List<ItemsModel> itemsService(ItemsModel obj) throws Exception {
        List<ItemsModel> x = itemsMapper.itemsMapper(obj);

        return x;
    }

}
