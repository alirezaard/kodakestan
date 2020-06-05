package com.kodakestan.kodak.models.dto;

import java.util.List;

/**
 * @author Alireza
 * @version 1.0.0
 * @date 6.5.2020
 */
public interface Crud<In, Out> {
    Out insert(In in);

    void delete(In in);

    List<In> getAll();

    Out edit(In in);

    List<In> deleteAll();
}