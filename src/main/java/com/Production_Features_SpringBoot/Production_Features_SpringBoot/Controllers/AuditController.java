package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Controllers;

import com.Production_Features_SpringBoot.Production_Features_SpringBoot.Entity.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/audit")
public class AuditController {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @GetMapping(path = "/posts/{postId}")
    List<PostEntity> getPostRevision(@PathVariable Long postId){
        AuditReader reader= AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number>revisions=reader.getRevisions(PostEntity.class,postId);
        return revisions.stream().map(revisionsnumber->reader.find(PostEntity.class,postId,revisionsnumber)).collect(Collectors.toList());
    }

}
