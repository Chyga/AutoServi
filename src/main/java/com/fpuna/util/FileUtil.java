/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Administrador
 */
public class FileUtil {

    public static String getPath() {
        try {
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
                    .getExternalContext().getContext();

            return ctx.getRealPath("/");

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error", ""));
        }
        return null;

    }

    /*
     devuelve un hashmap con la ruta de fotos clinicas y el url para las imagenes
     */
    public static HashMap<String, String> getMapPathFotos() {
        try {
            HashMap<String, String> map = new HashMap<String, String>();

            String path = getPath() + "resources/imagenes/articulo_imagen/";
            map.put("path", path);
            map.put("url", "/resources/imagenes/articulo_imagen/");
            return map;
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error", ""));
        }
        return null;

    }


    /*
     devuelve un hashmap con la ruta de fotos clinicas y el url para las imagenes
     */
    public static String getPathFotos() {
        try {

            String path = getPath() + "resources/imagenes/articulo_imagen/";
            return path;
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error", ""));
        }
        return null;

    }

    /*
     copia un archivo generalmente cuando se usa el fileupload
     fileName: nombre del archivo a copiar
     in: Es el InputStream
     destination: ruta donde se guardara el archivo
  
     */
    public static Boolean copyFile(String fileName, InputStream in, String destination) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName), false);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            return true;
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error", ""));
        }
        return false;
    }

    private void createDirectory(String directoryName) {

        File theDir = new File("new folder");

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + directoryName);
            boolean result = false;

            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                System.out.println("DIR created");
            }
        }

    }
}
