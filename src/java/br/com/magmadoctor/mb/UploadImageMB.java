/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.mb;

import java.io.File;
import java.io.FileOutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class UploadImageMB {

    public UploadImageMB() {
    }

    public void fileUploadAction(FileUploadEvent event) {
        try {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

            FacesContext aFacesContext = FacesContext.getCurrentInstance();
            ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();

            String realPath = context.getRealPath("/");

// Aqui cria o diretorio caso não exista
            File file = new File(realPath + "/fotos/");
            file.mkdirs();

            byte[] arquivo = event.getFile().getContents();
            String caminho = realPath + "/fotos/" + event.getFile().getFileName();

// esse trecho grava o arquivo no diretório
            FileOutputStream fos = new FileOutputStream(caminho);
            fos.write(arquivo);
            fos.close();

        } catch (Exception ex) {
            System.out.println("Erro no upload de imagem" + ex);
        }
    }

}
