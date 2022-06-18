package ru.hse.homework4;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Serializer class.
 * @apiNote serialization interface.
 */
public interface Mapper {
    /**
     * Saves object to string.
     * @param object object to serialize.
     * @return serialized (String).
     * @throws IllegalAccessException illegal.
     */
    String writeToString(Object object) throws IllegalAccessException;

    /**
     * Enters serialized object into OutputStream.
     * @param object object to serialize.
     * @param stream target stream for serialized.
     * @throws IOException for input-output trouble case.
     * @throws IllegalAccessException illegal.
     */
    void write(Object object, OutputStream stream) throws IOException, IllegalAccessException;

    /**
     * Saves serialized object to file.
     * @param object object to serialize.
     * @param file target file to save serialized.
     * @throws IOException for input-output trouble case.
     * @throws IllegalAccessException illegal.
     */
    void write(Object object, File file) throws IOException, IllegalAccessException;
}