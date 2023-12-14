package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeanARepository extends JpaRepository<BeanA, Long> {
//Оскільки репозиторії успадковують JpaRepository, то вони вже мають базові CRUD методи
}
