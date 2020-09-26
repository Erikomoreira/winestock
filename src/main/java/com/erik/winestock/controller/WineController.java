package com.erik.winestock.controller;


import com.erik.winestock.dto.QuantityDTO;
import com.erik.winestock.dto.WineDTO;
import com.erik.winestock.exception.WineAlreadyRegisteredException;
import com.erik.winestock.exception.WineNotFoundException;
import com.erik.winestock.exception.WineStockExceededException;
import com.erik.winestock.service.WineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/wines")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WineController implements WineControllerDocs {

    private final WineService wineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WineDTO createWine(@RequestBody @Valid WineDTO wineDTO) throws WineAlreadyRegisteredException {
        return wineService.createWine(wineDTO);
    }

    @GetMapping("/{name}")
    public WineDTO findByName(@PathVariable String name) throws WineNotFoundException {
        return wineService.findByName(name);
    }

    @GetMapping
    public List<WineDTO> listWines() {
        return wineService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws WineNotFoundException {
        wineService.deleteById(id);
    }

    @PatchMapping("/{id}/increment")
    public WineDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws WineNotFoundException, WineStockExceededException {
        return wineService.increment(id, quantityDTO.getQuantity());
    }
}