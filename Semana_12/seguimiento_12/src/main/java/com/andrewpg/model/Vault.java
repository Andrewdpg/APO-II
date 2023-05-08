package com.andrewpg.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.andrewpg.exception.WrongPasswordException;
import com.google.gson.Gson;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Vault {

    private static final String PAHT = "vault/";
    private static final String FILE_NAME = "data.json";

    private static Vault vault;

    public String password;
    public String text;

    public Vault() {
    }

    public Vault(String password, String text) {
        this.password = password;
        this.text = text;
    }

    public static void initVault() throws IOException {
        File file = new File(PAHT + FILE_NAME);
        if (!file.exists()) {
            vault = new Vault("000000", "");
            saveVaultConfig();
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String content = "";
        String line = "";
        while ((line = reader.readLine()) != null) {
            content += line;
        }
        Gson json = new Gson();
        vault = json.fromJson(content, Vault.class);
        reader.close();
    }

    public static void saveVaultConfig() throws IOException {
        Gson json = new Gson();
        File folder = new File(PAHT);
        if (!folder.exists())
            folder.mkdirs();
        File file = new File(PAHT + FILE_NAME);
        FileOutputStream fos = new FileOutputStream(file);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(json.toJson(vault));
        writer.close();
    }

    public static void checkPasswordGrammar(String password) throws WrongPasswordException{
        if (password.length() != 6)
            throw new WrongPasswordException("La contraseña debe ser de 8 caracteres");
    }

    public static void checkPassword(String password) throws WrongPasswordException {
        checkPasswordGrammar(password);
        if (vault.password.compareTo(password) != 0)
            throw new WrongPasswordException("Contraseña incorrecta");
    }

    public static void updateText(String text){
        vault.text = text;
    }

    public static void updatePassword(String oldP, String newP){
        try {
            Vault.checkPassword(oldP);
            Vault.checkPasswordGrammar(newP);
            vault.password = newP;
            saveVaultConfig();
        } catch (WrongPasswordException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.contentTextProperty().set(e.getMessage());
            alert.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.contentTextProperty().set("Error inesperado");
            alert.showAndWait();
        }
    }

    public static String getText(){
        return vault.text;
    }
}
