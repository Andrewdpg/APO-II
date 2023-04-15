package model.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class Storage {

    public static <T> Boolean saveJsonTo(String filename, String path, T obj) {
        try {
            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            File file = new File(path + filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            String data = new Gson().toJson(obj);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(data);
            writer.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error guardando el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static <T> T loadJsonFrom(String path, Class<T> type) throws IOException, FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("Archivo en la ruta " + path + " no encontrado o no existe.");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String content = "";
        String line = "";
        while ((line = reader.readLine()) != null) {
            content += line + "\n";
        }
        T data = new Gson().fromJson(content, type);
        reader.close();
        return data;
    }

}
