//package com.example.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//
//@Entity
//@Table(name = "skin")
//@Setter
//@Getter
//@ToString
//public class Skin {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "board_id", referencedColumnName = "id")
//    private Board board;
//
//    @Column(length = 300)
//    private String skin;
//
//}
