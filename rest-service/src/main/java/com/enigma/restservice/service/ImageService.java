package com.enigma.restservice.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface ImageService<E> {

    public Path save(E entity, MultipartFile file) throws IOException;

    public Resource load(E entity, String fileName) throws IOException;

    public List<Path> list(E entity) throws IOException;

    public void delete(E entity, String fileName) throws IOException;
}
