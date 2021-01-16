package com.enigma.restservice.controllers.classcontroller;

import com.enigma.restservice.entity.classentity.Item;
import com.enigma.restservice.model.classmodel.ItemModel;
import com.enigma.restservice.model.PageableList;
import com.enigma.restservice.model.ResponseMessage;
import com.enigma.restservice.service.IService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RequestMapping("/items")
@RestController
@Api(value = "Item", description = "Controller for Item", tags = {"item"})
public class ItemController {

    @Autowired
    private IService<Item> service;

    @PostMapping
    public ResponseMessage<ItemModel> save(@RequestBody @Valid ItemModel model) {

        Item entity = service.save(new Item(model.getName()));

        ModelMapper modelMapper = new ModelMapper();
        ItemModel data = modelMapper.map(entity, ItemModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ItemModel> edit(@PathVariable Integer id,
                                           @RequestBody @Valid ItemModel model) {

        ModelMapper modelMapper = new ModelMapper();

        model.setId(id);
        Item entity = service.findById(id);

        entity.setName(model.getName());
        entity = service.save(entity);
        ItemModel data = modelMapper.map(entity, ItemModel.class);

        return ResponseMessage.success(data);

    }

    @DeleteMapping("/{id}")
    public ResponseMessage<ItemModel> removeById(@PathVariable Integer id) {

        Item entity = service.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        ItemModel model = modelMapper.map(entity, ItemModel.class);

        return ResponseMessage.success(model);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ItemModel> findById(@PathVariable Integer id) {

        Item entity = service.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        ItemModel data = modelMapper.map(entity, ItemModel.class);

        return ResponseMessage.success(data);
    }

    @ApiOperation(value = "Find All Item", tags = {"item"})
    @ApiResponses({
            @ApiResponse(code = 200, message = "This is Response", response = ResponseMessage.class)
    })
    @GetMapping()
    public ResponseMessage<PageableList<ItemModel>> findAll(
            @RequestParam(required = false) @ApiParam(required = false) String name,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        if (size > 100) {
            size = 100;
        }

        Item entity = new Item(name);

        Sort.Direction direction = Sort.Direction.valueOf(sort.toUpperCase());
        Page<Item> pageItems = service.findAll(entity, page, size, direction);
        List<Item> items = pageItems.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<ItemModel>>() {
        }.getType();

        List<ItemModel> models = modelMapper.map(items, type);
        PageableList<ItemModel> data = new PageableList(models, pageItems.getNumber(),
                pageItems.getSize(), pageItems.getTotalElements());

        return ResponseMessage.success(data);
    }

}



