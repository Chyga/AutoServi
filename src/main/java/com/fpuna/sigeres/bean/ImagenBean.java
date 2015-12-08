/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpuna.sigeres.bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Administrador
 */
@ManagedBean
@SessionScoped
public class ImagenBean implements Serializable {

    

    public void handleFileUpload(FileUploadEvent event) {

        //get uploaded file from the event
        UploadedFile uploadedFile = (UploadedFile) event.getFile();

        //create an InputStream from the uploaded file
        InputStream inputStr = null;
        try {
            inputStr = uploadedFile.getInputstream();
        } catch (IOException e) {
            //log error
        }

        //create destination File
        String destPath = "your path here";
        File destFile = new File(destPath);

        //use org.apache.commons.io.FileUtils to copy the File
        try {
            //FileUtils.copyInputStreamToFile(inputStr, destFile);
        } catch (Exception e) {
            //log error
        }
    }

}
