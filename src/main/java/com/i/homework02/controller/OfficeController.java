package com.i.homework02.controller;

import com.i.homework02.entity.Office;
import com.i.homework02.exeption.CustomOfficeException;
import com.i.homework02.servise.serviceImpl.OfficeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.i.homework02.view.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/office", produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeController {

    @Autowired
    private OfficeServiceImpl officeServiceImpl;

    /**
     * Поиск офиса(ов) по нескольким параметрам
     * @param officeListViewIn - объект с параметрами поиска
     * @return Список офисов полученый из параметров запроса
     */
    @PostMapping(value = "/list")
    public
    ResponseEntity searchOffice(@RequestBody @Valid OfficeListViewIn officeListViewIn) throws CustomOfficeException {
        List<OfficeListViewOut> listOffices = officeServiceImpl.searchOffice(officeListViewIn);
        DataView<List<OfficeListViewOut>> dataView =new DataView<>(listOffices);
        return new ResponseEntity<>(dataView, HttpStatus.FOUND);
    }

    /**
     * Поиск офиса по Id
     * @param id - id офиса
     * @return - офис найденный по id
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity findOfficeById(@PathVariable Long id) throws CustomOfficeException {
        OfficeIdViewOut officeIdViewOut = officeServiceImpl.findById(id);
        DataView<OfficeIdViewOut> dataView =new DataView<>(officeIdViewOut);
        return new ResponseEntity<>(dataView, HttpStatus.FOUND);
    }

    /**
     * Изменение(обновление) параметров офиса
     * @param officeViewIn - парметры офиса переданные для удаления
     */
    @PostMapping(value = "/update")
    public
    ResponseEntity officeUpdate (@RequestBody @Valid OfficeViewIn officeViewIn) throws CustomOfficeException {
        officeServiceImpl.update(officeViewIn);
        return new ResponseEntity<>(new PositiveResponseView(), HttpStatus.OK);
    }

    /**
     * Сохранение офиса
     * @param officeSaveViewIn - объект с параметрами для сохранения
     */
    @PostMapping(value = "/save")
    public
    ResponseEntity officeSave (@RequestBody OfficeSaveViewIn officeSaveViewIn) throws CustomOfficeException {
        officeServiceImpl.save(officeSaveViewIn);
        return new ResponseEntity<>(new PositiveResponseView(), HttpStatus.CREATED);
    }

    /**
     * Удаление офиса
     * @param officeViewIn объект с параметром id офиса
     */
    @PostMapping(value = "/delete")
    public
    ResponseEntity officeDelete (@RequestBody OfficeViewIn officeViewIn) throws CustomOfficeException {
        officeServiceImpl.delete(officeViewIn);
        return new ResponseEntity<>(new PositiveResponseView(), HttpStatus.OK);
    }
}

