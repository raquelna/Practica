package com.lab.persistence.mapper;

import com.lab.persistence.model.ItemsModel;
import java.util.List;


public interface ItemsMapper {
    
    public List<ItemsModel> itemsMapper(ItemsModel obj) throws Exception;

    public List<ItemsModel> buscarItemsMapper(ItemsModel obj) throws Exception;
    
}
