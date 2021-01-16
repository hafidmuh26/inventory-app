package com.enigma.restservice.controllers.classcontroller;

import com.enigma.restservice.entity.classentity.Transaction;
import com.enigma.restservice.model.PageableList;
import com.enigma.restservice.model.ResponseMessage;
import com.enigma.restservice.model.classmodel.TransactionModel;
import com.enigma.restservice.entity.TypeTransaction;
import com.enigma.restservice.model.classmodel.TransactionSummary;
import com.enigma.restservice.service.IService;
import com.enigma.restservice.service.TransactionSumService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.time.Month;
import java.time.Year;
import java.util.List;


@RequestMapping("/transactions")
@RestController
public class TransactionController {

    @Autowired
    private IService<Transaction> service;

    @Autowired
    private TransactionSumService summaryService;

    @PostMapping
    public ResponseMessage<TransactionModel> save(@RequestBody @Valid TransactionModel model) {
        Transaction entity = service.save(new Transaction(model.getAmount(), TypeTransaction.fromValue(model.getType()), model.getDescription()));

        ModelMapper modelMapper = new ModelMapper();
        TransactionModel data = modelMapper.map(entity, TransactionModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<TransactionModel> edit(@PathVariable Integer id,
                                                  @RequestBody @Valid TransactionModel model) {

        ModelMapper modelMapper = new ModelMapper();

        model.setId(id);
        Transaction entity = service.findById(id);
        entity.setAmount(model.getAmount());
        entity.setType(TypeTransaction.fromValue(model.getType()));
        entity.setDescription(model.getDescription());

        entity = service.save(entity);
        TransactionModel data = modelMapper.map(entity, TransactionModel.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<TransactionModel> removeById(@PathVariable Integer id) {

        Transaction entity = service.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        TransactionModel model = modelMapper.map(entity, TransactionModel.class);

        return ResponseMessage.success(model);
    }

    @GetMapping("/{id}")
    public ResponseMessage<TransactionModel> findById(@PathVariable Integer id) {

        Transaction entity = service.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        TransactionModel data = modelMapper.map(entity, TransactionModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<TransactionModel>> findAll(
            @RequestParam(required = false) Double amount,
            @RequestParam(required = false) TypeTransaction typeTransaction,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }
        Transaction entity = new Transaction(amount, typeTransaction, description);
        Sort.Direction direction = Sort.Direction
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<Transaction> pageTransactions = service.findAll(entity, page, size, direction);
        List<Transaction> transactions = pageTransactions.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<TransactionModel>>() {
        }.getType();
        List<TransactionModel> transactionModels = modelMapper.map(transactions, type);
        PageableList<TransactionModel> data = new PageableList(transactionModels, pageTransactions.getNumber(),
                pageTransactions.getSize(), pageTransactions.getTotalElements());

        return ResponseMessage.success(data);
    }

    @GetMapping("/summary")
    public ResponseMessage<List<TransactionSummary>> TransactionSummary(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer day) {

        List<TransactionSummary> entities = summaryService.summary(
                year != null ? Year.of(year) : Year.now(),
                month != null ? Month.of(month) : null,
                day != null ? day : null);
        System.out.println(entities);

        return ResponseMessage.success(entities);
    }
}
