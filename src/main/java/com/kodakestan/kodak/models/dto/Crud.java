package com.kodakestan.kodak.models.dto;

import java.util.List;

public interface Crud<In, Out> {
    Out insert(In in);
    void delete(In in);
    List<In> getAll();
    Out edit(In in);
    List<In> deleteAll();
}