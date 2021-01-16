package com.enigma.restservice.controllers.classcontroller;

import com.enigma.restservice.entity.classentity.Item;
import com.enigma.restservice.entity.classentity.Stock;
import com.enigma.restservice.entity.classentity.Unit;
import com.enigma.restservice.model.*;
import com.enigma.restservice.model.classmodel.ItemModel;
import com.enigma.restservice.model.classmodel.StockModel;
import com.enigma.restservice.model.classmodel.StockRequest;
import com.enigma.restservice.model.classmodel.StockSummary;
import com.enigma.restservice.service.IService;
import com.enigma.restservice.service.StockSummaryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

@RequestMapping("/stocks")
@RestController
public class StockController {

    @Autowired
    private IService<Stock> service;

    @Autowired
    private IService<Unit> unitIService;

    @Autowired
    private IService<Item> itemIService;

    @Autowired
    private StockSummaryService summaryService;

    @PostMapping
    public ResponseMessage<StockRequest> save(@RequestBody @Valid StockRequest model) {

        Item item = itemIService.findById(model.getItemId());
        Unit unit = unitIService.findById(model.getUnitId());

        Stock entity = new Stock(item, model.getQuantity(), unit);
        service.save(entity);

        ModelMapper modelMapper = new ModelMapper();
        StockRequest data = modelMapper.map(entity, StockRequest.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<StockModel> edit(@PathVariable Integer id, @RequestBody @Valid StockRequest model) {
        ModelMapper modelMapper = new ModelMapper();

        Stock entity = service.findById(id);

        entity.setItem(itemIService.findById(model.getItemId()));
        entity.setUnit(unitIService.findById(model.getUnitId()));
        entity.setQuantity(model.getQuantity());
        entity = service.save(entity);

        StockModel data = modelMapper.map(entity, StockModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<StockModel> findById(@PathVariable Integer id) {

        Stock entity = service.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        StockModel data = modelMapper.map(entity, StockModel.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<StockModel> removeById(@PathVariable Integer id) {

        Stock entity = service.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        StockModel model = modelMapper.map(entity, StockModel.class);

        return ResponseMessage.success(model);
    }

    @GetMapping()
    public ResponseMessage<PageableList<StockModel>> findAll(
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) Item itemId,
            @RequestParam(required = false) Unit unitId,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        if (size > 100) {
            size = 100;
        }

        Stock entity = new Stock(itemId, quantity, unitId);

        Sort.Direction direction = Sort.Direction.fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<Stock> pageStocks = service.findAll(entity, page, size, direction);
        List<Stock> stocks = pageStocks.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<StockModel>>() {
        }.getType();

        List<StockModel> models = modelMapper.map(stocks, type);
        PageableList<StockModel> data = new PageableList(models, pageStocks.getNumber(),
                pageStocks.getSize(), pageStocks.getTotalElements());

        return ResponseMessage.success(data);
    }

    @GetMapping("/summary")
    public ResponseMessage<List<StockSummary>> stockSummary() throws SQLException {
        List<StockSummary> entities = summaryService.stockSummary();

        return ResponseMessage.success(entities);
    }


}
