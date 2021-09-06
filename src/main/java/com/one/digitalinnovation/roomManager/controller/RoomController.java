package com.one.digitalinnovation.roomManager.controller;

import com.one.digitalinnovation.roomManager.exception.ResourceNotFoundException;
import com.one.digitalinnovation.roomManager.model.Room;
import com.one.digitalinnovation.roomManager.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) throws ResourceNotFoundException {
        Room room = roomRepository.findById(id).
                orElseThrow(
                        () -> new ResourceNotFoundException("Room not found: " + id)
                );
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room) {
        Room savedRoom = roomRepository.save(room);
        return savedRoom;
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@Valid @RequestBody Room room, @PathVariable Long id) throws ResourceNotFoundException {
        roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));

        Room savedRoom = roomRepository.save(room);
        return ResponseEntity.ok().body(room);
    }

    @DeleteMapping("/rooms/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable Long id) throws ResourceNotFoundException{
        Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
        roomRepository.delete(room);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
