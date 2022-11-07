package com.example.presenceqrcode.repository;

import com.example.presenceqrcode.model.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresenceRepository extends JpaRepository<Presence, String> {
}
