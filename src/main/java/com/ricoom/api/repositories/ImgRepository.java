package com.ricoom.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricoom.api.models.ProductImg;

public interface ImgRepository extends JpaRepository<ProductImg, Long> {
  Optional<ProductImg> findByname(String imgname);
}
