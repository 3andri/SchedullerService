package com.andri.service.lelang.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andri.service.lelang.Model.bri_rumah;

@Repository
public interface bri_rumahRepo  extends JpaRepository<bri_rumah, String>{

}
