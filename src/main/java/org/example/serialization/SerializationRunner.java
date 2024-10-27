package org.example.serialization;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;


public class SerializationRunner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Path.of("files", "user.out");
        write(path);
        read(path);
    }


    private static void write(Path path) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            oos.writeObject(new User("Bill", 42, "male"));
        }
    }

    private static void read(Path path) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            Object o = ois.readObject();
            System.out.println(o);
        }
    }
}
