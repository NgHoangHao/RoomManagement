package com.example.RoomManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "floors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String floorName;
    private Integer level;
    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;
    @OneToMany(mappedBy = "floor")
    private List<Room> rooms;
}