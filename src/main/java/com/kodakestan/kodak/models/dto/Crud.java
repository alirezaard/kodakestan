package com.kodakestan.kodak.models.dto;

import com.kodakestan.kodak.models.entities.Image;

import java.io.Serializable;
import java.util.List;

/**
 * @author Alireza
 * @version 1.0.0
 * date 6.5.2020
 */
public interface Crud<In, Out> extends Serializable {
    Out insert(In in);
    void delete(In in);
    List<In> getAll();
    Out edit(In in);
    List<In> deleteAll();
    Out addImage(Image img);
}