package com.example.respostapeloperidododiaweb;

import java.io.*;
import java.time.LocalTime;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RespostaBomDiaOuNoiteServlet", value = "/bom-dia-tarde-noite")
public class RespostaBomDiaOuNoiteServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String msg;
        int horaDia = LocalTime.now().getHour();
        if(horaDia > 5 && horaDia <= 12){
            msg = String.format("Bom dia, %s!", nome);
        } else if (horaDia > 12 && horaDia <=18) {
            msg = String.format("Boa tarde, %s!", nome);
        }else {
            msg = String.format("Boa noite, %s!", nome);
        }
        request.setAttribute("msg", msg);
        RequestDispatcher rd = request.getRequestDispatcher("/msg.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }


}

//    Escreva uma aplicação que peça ao usuário seu nome e e-mail e imprima uma página de boas vindas dependente do horário do dia.
//        Ex.: "Bom dia, Ana!", se for de manhã.
//        Na solução utilize:
//        a) Uma página HTML fixa com um formulário para pedir a informação
//        b) Uma página HTML dinâmica para apresentar o resultado
//        c) Um servlet para processar o request e gerar a página de boas vindas (ATENÇÂO: Use o método POST!)