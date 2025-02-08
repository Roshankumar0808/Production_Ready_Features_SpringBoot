package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Repositories;

import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface postRepo extends JpaRepository<PostEntity,Long> {

}
