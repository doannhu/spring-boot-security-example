package com.javatechie.controller;

import com.javatechie.entity.Room;
import com.javatechie.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/room") // This means URL's start with /demo (after Application path)
public class RoomController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private RoomRepository roomRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public @ResponseBody String addNewRoom (@RequestParam String title,
                                            @RequestParam String description,
                                            @RequestParam Float price,
                                            @RequestParam Float area,
                                            @RequestParam Float rating,
                                            @RequestParam Integer capacity) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Room aRoom = new Room();
        aRoom.setTitle(title);
        aRoom.setDescription(description);
        aRoom.setPrice(price);
        aRoom.setArea(area);
        aRoom.setRating(rating);
        aRoom.setCapacity(capacity);
        roomRepository.save(aRoom);
        return "Saved this room";
    }


    @GetMapping(path="/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public @ResponseBody Iterable<Room> getAllRooms() {
        // This returns a JSON or XML with the users
        return roomRepository.findAll();
    }
}
