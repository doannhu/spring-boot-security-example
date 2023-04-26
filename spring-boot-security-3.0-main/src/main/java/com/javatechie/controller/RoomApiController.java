package com.javatechie.controller;


import com.javatechie.entity.Room;
import com.javatechie.repository.RoomRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/room")
public class RoomApiController {
    private RoomRepository repository;
    RoomApiController(RoomRepository repository) {
        this.repository = repository;
    }
    @PostMapping(path="/add")
    Room newRoom(@RequestBody Room newRoom) {
        return repository.save(newRoom);
    }
}
