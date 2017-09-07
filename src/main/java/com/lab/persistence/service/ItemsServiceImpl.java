package com.lab.persistence.service;

import com.lab.persistence.mapper.ItemsMapper;
import com.lab.persistence.model.ItemsModel;
import java.util.List;
import java.util.regex.Pattern;
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

    @Override
    public List<ItemsModel> buscarItemsService(ItemsModel obj) throws Exception {
        List<ItemsModel> x = itemsMapper.buscarItemsMapper(obj);

        return this.replaceSearch(obj, x);
    }


    private List<ItemsModel> replaceSearch(ItemsModel obj, List<ItemsModel> x) throws Exception {

        for (ItemsModel item : x) {
            item.setNombre(this.pattern(obj.getNombre()).matcher(item.getNombre()).replaceAll(this.patternReplace(obj.getNombre())));
            item.setDescripcion(this.pattern(obj.getDescripcion()).matcher(item.getDescripcion()).replaceAll(this.patternReplace(obj.getDescripcion())));
        }

        return x;
    }

    /**
     * METODO PARA GENERAR UN PATRON.
     *
     * @param str Cadena a insertar en el patron de busqueda.
     * @return Patron generado.
     */
    private Pattern pattern(String str) {
        return Pattern.compile("(?i)" + str);
    }

    /**
     * METODO PARA REALIZAR UN REMPLAZO DE UNA CADENA POR UN TAG HTML.
     *
     * @param str Cadena a insertar en el tag.
     * @return tag generado en html.
     */
    private String patternReplace(String str) {
        return "<span class=\"found\">" + str + "</span>";
    }

}
