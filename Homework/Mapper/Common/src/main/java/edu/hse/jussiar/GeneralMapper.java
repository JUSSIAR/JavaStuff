package edu.hse.jussiar;

import ru.hse.homework4.Mapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GeneralMapper implements Mapper {
    @Override
    public String writeToString(Object object) throws IllegalAccessException {
        return MapperRouter.map(object);
    }

    @Override
    public void write(Object object, OutputStream stream) throws IOException, IllegalAccessException {
        stream.write(writeToString(object).getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void write(Object object, File file) throws IOException, IllegalAccessException {
        FileWriter writer = new FileWriter(file);
        writer.write(writeToString(object));
        writer.flush();
    }
}
