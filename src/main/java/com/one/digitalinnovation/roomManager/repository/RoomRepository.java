package com.one.digitalinnovation.roomManager.repository;

import com.one.digitalinnovation.roomManager.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
