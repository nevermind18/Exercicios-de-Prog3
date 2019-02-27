/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restinga.ifrs.edu.br.Bruno.Santos.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Bruno
 */
@Controller
public class NewClass {

    @RequestMapping("/imc")
    @ResponseBody
    public String imc(@RequestParam double altura, @RequestParam double peso) {

        double resultado = peso / Math.pow(altura, 2);

        String imc = "ts";

        if (resultado < 18.5) {
            imc = "Abaixo do peso";
        } else if (resultado >= 18.5 && resultado < 24.9) {
            imc = "Saudável";
        } else if (resultado > 24.9 && resultado <= 29.9) {
            imc = "sobrepeso";
        } else if (resultado > 29.9 && resultado <= 34.9) {
            imc = "Obesidade Grau 1";
        } else if (resultado > 34.9 && resultado <= 39.9) {
            imc = "Obesidade Grau 2";
        } else if (resultado > 39.9) {
            imc = "Obesidade Grau 3";
        } else {
            imc = "erro";
        }

        return imc + " seu imc é: " + resultado;
    }

    @RequestMapping("/diaSemana/{ano}/{mes}/{dia}")
    @ResponseBody
    public String diaSemana(@PathVariable int ano,
            @PathVariable int mes, @PathVariable int dia) {

        int a = (int) (14 - mes) / 12;
        int b = (int) ano - a;
        int c = (int) mes + (12 * a) - 2;
        int d = (int) dia + ((31 * c) / 12) + b + (b / 4) - (b / 100) + (b / 400);
        int r = d % 7 + 1;

        String resultado = "";

        switch (r) {
            case 1:
                resultado = "domingo";
                break;
            case 2:
                resultado = "segunda";
                break;
            case 3:
                resultado = "terça";
                break;
            case 4:
                resultado = "quarta";
                break;
            case 5:
                resultado = "quinta";
                break;
            case 6:
                resultado = "sexta";
                break;
            case 7:
                resultado = "sabado";
                break;
        }
        return resultado;
    }

    @RequestMapping("/calcular/soma/{a}/{b}")
    @ResponseBody
    public double calcularSoma(@PathVariable int a, @PathVariable int b) {
        
        return  a + b;
    }
    
    @RequestMapping("/calcular/sub/{a}/{b}")
    @ResponseBody
    public double calcularSub(@PathVariable int a, @PathVariable int b) {
        
        return  a - b;
    }
    
    @RequestMapping("/calcular/div/{a}/{b}")
    @ResponseBody
    public double calcularDiv(@PathVariable int a, @PathVariable int b) {
        
        return  a / b;
    }
    
    @RequestMapping("/calcular/mult/{a}/{b}")
    @ResponseBody
    public double calcularMult(@PathVariable int a, @PathVariable int b) {
        
        return  a * b;
    }
}
