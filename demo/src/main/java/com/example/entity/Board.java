//package com.example.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "board")
//@ToString
//public class Board {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    private Category category;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private Member member;
//}
