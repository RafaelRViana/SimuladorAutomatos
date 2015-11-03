package br.unisc.simuladorautomatos.core;

public class Logger {
 
    private static StringBuilder log = new StringBuilder();
    
    public static void clear() {
        log = new StringBuilder();
    }
    
    public static void log(String mensagem) {
        log.append(mensagem);
        log.append("\n");
    }
    
    public static String getLog() {
        return log.toString();
    }
    
}