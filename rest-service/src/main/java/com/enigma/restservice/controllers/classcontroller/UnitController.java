package com.enigma.restservice.controllers.classcontroller;


import com.enigma.restservice.entity.classentity.Unit;
import com.enigma.restservice.model.PageableList;
import com.enigma.restservice.model.ResponseMessage;
import com.enigma.restservice.model.classmodel.UnitModel;
import com.enigma.restservice.service.IService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;


@RequestMapping("/units")
@RestController
public class UnitController {

    @Autowired
    private IService<Unit> unitService;

    @PostMapping
    public ResponseMessage<UnitModel> save(@RequestBody @Valid UnitModel model) {

        Unit entity = (new Unit(model.getName(), model.getDescription()));
        unitService.save(entity);

        ModelMapper modelMapper = new ModelMapper();
        UnitModel data = modelMapper.map(entity, UnitModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<UnitModel> edit(@PathVariable Integer id,
                                           @RequestBody @Valid UnitModel model) {

        ModelMapper modelMapper = new ModelMapper();
        model.setId(id);
        Unit entity = unitService.findById(id);

        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity = unitService.save(entity);
        UnitModel data = modelMapper.map(entity, UnitModel.class);

        return ResponseMessage.success(data);

    }

    @DeleteMapping("/{id}")
    public ResponseMessage<UnitModel> removeById(@PathVariable Integer id) {

        Unit entity = unitService.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        UnitModel model = modelMapper.map(entity, UnitModel.class);

        return ResponseMessage.success(model);
    }

    @GetMapping("/{id}")
    public ResponseMessage<UnitModel> findById(@PathVariable Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        Unit entity = unitService.findById(id);
        UnitModel data = modelMapper.map(entity, UnitModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping()
    public ResponseMessage<PageableList<UnitModel>> findAll(
            @RequestParam(required = false) String name, String description,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        if (size > 100) {
            size = 100;
        }

        Unit entity = new Unit(name, description);
        Sort.Direction direction = Sort.Direction.valueOf(sort.toUpperCase());
        Page<Unit> pageUnits = unitService.findAll(entity, page, size, direction);
        List<Unit> units = pageUnits.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<UnitModel>>() {
        }.getType();
        List<UnitModel> models = modelMapper.map(units, type);
        PageableList<UnitModel> data = new PageableList(models, pageUnits.getNumber(),
                pageUnits.getSize(), pageUnits.getTotalElements());

        return ResponseMessage.success(data);
    }
}
