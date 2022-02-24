package com.manhlee.productspringmvc.service;

import com.manhlee.productspringmvc.entities.ImageEntity;
import com.manhlee.productspringmvc.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<ImageEntity> getImages(){
        return (List<ImageEntity>) imageRepository.findAll();
    }

    public void save(ImageEntity image){
        imageRepository.save(image);
    }
}
