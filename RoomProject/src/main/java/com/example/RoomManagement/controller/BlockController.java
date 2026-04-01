package com.example.RoomManagement.controller;

import com.example.RoomManagement.dto.request.BlockDto;
import com.example.RoomManagement.dto.response.BlockDetailDto;
import com.example.RoomManagement.dto.response.GetBlockDto;
import com.example.RoomManagement.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlockController {
    @Autowired
    private BlockService blockService;

    @PostMapping("/add-block")
    public ResponseEntity<BlockDto> addBlock(@RequestBody BlockDto blockDto) {
        BlockDto block = blockService.addNewBlock(blockDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(block);
    }
    @GetMapping("/get-block-data/{id}")
    public ResponseEntity<BlockDetailDto> getBlockDetail(@RequestParam Long id){
        return ResponseEntity.ok(blockService.getBlockDetail(id));

    }

    @GetMapping("/get-all-block")
    public ResponseEntity<List<GetBlockDto>> getAllBlocks() {
        return ResponseEntity.ok(blockService.getAllBlock());
    }
}
