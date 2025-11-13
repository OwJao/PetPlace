/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.cli;

import java.io.IOException;

/**
 *
 * @author JOAO
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 INICIANDO PET PLACE...\n");
        
        int tentativas = 0;
        int maxTentativas = 3;
        
        while (tentativas < maxTentativas) {
            try {
                PetPlace app = new PetPlace();
                app.iniciar();
                break; // Se chegou aqui, tudo funcionou - sai do loop
            } catch (Exception e) {
                tentativas++;
                System.out.println("💥 ERRO CRÍTICO (" + tentativas + "/" + maxTentativas + "): " + e.getMessage());
                System.out.println("🔧 Verifique sua conexão com o banco MySQL!");
                
                if (tentativas < maxTentativas) {
                    System.out.println("\n⏳ Tentando novamente em 5 segundos...");
                    try { Thread.sleep(5000); } catch (InterruptedException ie) {}
                    
                    // Limpa um pouco a tela
                    for (int i = 0; i < 10; i++) {
                        System.out.println();
                    }
                } else {
                    System.out.println("❌ Número máximo de tentativas atingido.");
                    System.out.println("📋 Certifique-se de que:");
                    System.out.println("   - MySQL está rodando na porta 3306");
                    System.out.println("   - Banco 'petshop' existe");
                    System.out.println("   - Usuário/senha estão corretos no ConnectionMySQL");
                    System.out.println("\nPressione Enter para sair...");
                    try { System.in.read(); } catch (IOException ex) {}
                }
            }
        }
    }
}
