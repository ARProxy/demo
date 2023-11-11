//package com.example.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "post_it")
//@Getter
//@Setter
//@ToString
//public class Postit {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "board_id", referencedColumnName = "id")
//    private Board board;
//
//    @Column(name = "post_contents", length = 1000)
//    private String postContents;
//
//    @Column(name = "post_picture", length = 300)
//    private String postPicture;
//
//    @Column(name = "reg_date", nullable = false)
//    private LocalDateTime regDate;
//
//}
