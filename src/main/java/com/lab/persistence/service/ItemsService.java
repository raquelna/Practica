package com.lab.persistence.service;

import com.lab.persistence.model.ItemsModel;
import java.util.List;


public interface ItemsService {
    
    public List<ItemsModel> itemsService(ItemsModel obj) throws Exception;

    public List<ItemsModel> buscarItemsService(ItemsModel obj) throws Exception;
    
    
}
