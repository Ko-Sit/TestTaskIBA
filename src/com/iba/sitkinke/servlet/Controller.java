package com.iba.sitkinke.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iba.sitkinke.resource.ConfigurationManager;
import com.iba.sitkinke.command.ActionCommand;
import com.iba.sitkinke.command.factory.ActionFactory;

@WebServlet("/controller")
@MultipartConfig
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = null;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        page = command.execute(request);
        if (request.getParameter("command").equals("save")) {
            String filePath = "file.xml";
            File downloadFile = new File(filePath);
            HttpSession httpSession = request.getSession();
            String fileName = (String) httpSession.getAttribute("filename");
            System.out.println(fileName);

            FileInputStream inStream = new FileInputStream(downloadFile);

            String relativePath = getServletContext().getRealPath("");
            System.out.println("relativePath = " + relativePath);

            ServletContext context = getServletContext();

            String mimeType = context.getMimeType(filePath);
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            System.out.println("MIME type: " + mimeType);

            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());

            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", fileName);
            response.setHeader(headerKey, headerValue);

            OutputStream outStream = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

            inStream.close();
            outStream.close();
        }
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
        else {
            page = ConfigurationManager.getProperty("path.page.index");
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}