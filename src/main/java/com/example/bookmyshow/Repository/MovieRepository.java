package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movies,Integer> {
    Movies findByname(String movieName);//movie entity mai jo name hai of attribute,write that after findBy
}
