package com.lab.controllers;


import com.lab.persistence.model.ItemsModel;
import com.lab.persistence.service.ItemsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Items {
    
    @Autowired
  ItemsService itemsService;


  @ResponseBody
  @RequestMapping(value = "/getItems",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ItemsModel> items(@RequestBody ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = itemsService.itemsService(obj);

    return x;
  }
    
}
