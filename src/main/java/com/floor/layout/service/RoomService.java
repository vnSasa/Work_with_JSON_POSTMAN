package com.floor.layout.service;

import com.floor.layout.host.Point;
import com.floor.layout.host.Room;
import com.floor.layout.dto.RoomResDto;
import com.floor.layout.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomResDto getRoom(Long id) {
        return roomToDto(findById(id));
    }

    public List<RoomResDto> getAllRooms() {
        return findAllRooms()
                .stream()
                .map(this::roomToDto)
                .collect(Collectors.toList());
    }

    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    public void editRoom(Long id, Collection<Point> points) {
        Room room = findById(id);
        room.setPoints(new ArrayList<>(points));

        roomRepository.save(room);
    }

    public void removeRoom(Long id) {
        roomRepository.deleteById(id);
    }

    private Room findById(Long id) {
        return roomRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Room with id " + id + " doesn't exist"));
    }

    private List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    private RoomResDto roomToDto(Room room) {
        RoomResDto res = new RoomResDto();
        res.setId(room.getId());
        res.setSize(room.getPoints().size());
        res.setCorners(room.getPoints());

        return res;
    }
}