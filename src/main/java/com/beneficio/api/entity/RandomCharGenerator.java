/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.api.entity;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author BYRON
 */
public class RandomCharGenerator {
    
    public String generarPassword(){
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        int next1 = random.nextInt(chars.length);
        int next2 = random.nextInt(chars.length);
        int next3 = random.nextInt(chars.length);
        int next4 = random.nextInt(chars.length);
        int next5 = random.nextInt(chars.length);
        char randomChar1 = chars[next1];
        char randomChar2 = chars[next2];
        char randomChar3 = chars[next3];
        char randomChar4 = chars[next4];
        char randomChar5 = chars[next5];
        
        String password =  "" + randomChar1 + randomChar2 + randomChar3 + randomChar4 + randomChar5;
        
        return password;
    }
    
     // Método para generar una contraseña alfanumérica aleatoria de una longitud específica
    public static String generateRandomPassword(int len){
        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`
 
        for (int i = 0; i < len; i++){
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
    
    public static String generateUsuario(){
        StringBuilder usuario = new StringBuilder();
        
        LocalDateTime fechaActual = LocalDateTime.now();
        
        usuario.append("").append(fechaActual.getYear()).append(fechaActual.getMonthValue()).append(fechaActual.getDayOfMonth()).append(fechaActual.getHour()).append(fechaActual.getMinute());
        
        return usuario.toString();
    }
}
