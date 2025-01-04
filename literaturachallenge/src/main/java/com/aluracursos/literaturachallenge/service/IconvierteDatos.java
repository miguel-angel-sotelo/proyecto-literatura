package com.aluracursos.literaturachallenge.service;

public interface IconvierteDatos {

        <T> T obtenerDatos(String json, Class<T> clase);
}

