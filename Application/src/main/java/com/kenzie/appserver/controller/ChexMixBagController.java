package com.kenzie.appserver.controller;

import com.kenzie.appserver.controller.model.ChexMixBagCreateRequest;
import com.kenzie.appserver.controller.model.ChexMixBagResponse;
import com.kenzie.appserver.service.ChexMixBagService;
import com.kenzie.appserver.service.model.ChexMixBagDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chexmix")
public class ChexMixBagController {

    // Injecting ChexMixService dependency
    private ChexMixBagService chexMixBagService;
    private ModelMapper modelMapper;

    @Autowired
    public ChexMixBagController(ChexMixBagService chexMixBagService,ModelMapper modelMapper) {
        this.chexMixBagService = chexMixBagService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ChexMixBagResponse> get(@PathVariable("id") String id) {
        ChexMixBagDTO chexMixBagDTO = chexMixBagService.findById(id);
        if (chexMixBagDTO == null) {
            return ResponseEntity.notFound().build();
        }

        ChexMixBagResponse chexMixBagResponse = modelMapper.map(chexMixBagDTO, ChexMixBagResponse.class);
        return ResponseEntity.ok(chexMixBagResponse);
    }

    @PostMapping
    public ResponseEntity<ChexMixBagResponse> addNewChexMixBag(@RequestBody ChexMixBagCreateRequest chexMixBagCreateRequest) {
        ChexMixBagDTO chexMixBagDTO = modelMapper.map(chexMixBagCreateRequest, ChexMixBagDTO.class);
        chexMixBagService.addNewChexMixBag(chexMixBagDTO);

        ChexMixBagResponse chexMixBagResponse = modelMapper.map(chexMixBagDTO, ChexMixBagResponse.class);

        return ResponseEntity.created(URI.create("/chexMixBagDTO/" + chexMixBagResponse.getId())).body(chexMixBagResponse);
    }

    @DeleteMapping("/{batchNumber}")
    public ResponseEntity<Void> removeChexMix(@PathVariable("batchNumber") String batchNumber) {
        chexMixBagService.removeChexMixByBatchNumber(batchNumber);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ChexMixBagDTO>> getAvailableChexMix() {
      // ???? //List<ChexMixBagDTO> availableChexMix = chexMixBagService.getAvailableChexMix();
       // return ResponseEntity.ok(availableChexMix);
       return  null;
    }

    @GetMapping("/quantity")
    public ResponseEntity<Map<String, Integer>> trackChexMixQuantity() {
        Map<String, Integer> chexMixQuantity = chexMixBagService.trackChexMixQuantity();
        return ResponseEntity.ok(chexMixQuantity);
    }
}