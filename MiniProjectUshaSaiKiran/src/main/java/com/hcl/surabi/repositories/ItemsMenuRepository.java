package com.hcl.surabi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.surabi.entities.*;

@Repository
public interface ItemsMenuRepository extends JpaRepository<Menu,Long>{


   // USER DEFINED METHOD TO FIND THE ITEM BY ITS NAME
   public Menu findByItemName(String itemname);
}