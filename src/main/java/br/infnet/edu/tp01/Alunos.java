
package br.infnet.edu.tp01;

import java.util.Arrays;
import java.util.Scanner;

public class Alunos {
    
    private static String[] nomeAluno;
    private static float[] notaAv1;
    private static float[] notaAv2;
    
    int quantidade = 0;
    
    public static void main(String[] args) {  
        
        int QTD = 3;
        int executor = 0;
        int quantidade = 0;
        
        Scanner entrada = new Scanner(System.in);
        
        nomeAluno = new String[QTD];
        notaAv1 = new float[QTD];
        notaAv2 = new float[QTD];
        
        do{
            
            executor = lerExecutor();
            
            switch(executor){
                case 1 -> {
                    cadastrarAluno(quantidade);
                    quantidade++;
                    break;
                }
                case 2 -> {
                    System.out.println("Digite o ID do aluno: ");
                    int id = entrada.nextInt();
                    exibirAlunos(id);
                    System.out.println("Consulta encerrada.");
                    break;
                }
                case 3 -> {
                    for (int i = 0; i < quantidade; i++) {
                        exibirAlunos(i);     
                    System.out.println("Consulta encerrada.");
                    }
                    break;
                }
                case 4 -> {
                    System.out.println("Você saiu do sistema.");
                    break;
                }
                default -> {
                    System.out.println("Opção não reconhecida.");
                    break;
                }
            }
            
        } while(executor != 4);
    }
    
    public static int lerExecutor(){
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("[1] - Registrar as notas de um aluno.");
        System.out.println("[2] - Consultar boletim de um aluno.");
        System.out.println("[3] - Consultar notas da turma.");
        System.out.println("[4] - Sair.");
        
        int executor = entrada.nextInt();
        
        return executor;
    }
    
    public static void cadastrarAluno(int quantidade){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite o nome do aluno: ");
        nomeAluno[quantidade] = entrada.nextLine();
        System.out.println("Digite a nota da AV1: ");
        notaAv1[quantidade] = entrada.nextFloat();
        System.out.println("Digite a nota da AV2: ");
        notaAv2[quantidade] = entrada.nextFloat();
        System.out.println("Dados registrados! O ID do aluno é:" + quantidade );
        
    }
    
    public static void calcularMedia(float n1, float n2){
        float media = (n1 + n2) / 2;
        String status = verificarStatus(media);
        System.out.println("Média do aluno: "+media);
        System.out.println("Status: "+status);
    }
    
    public static String verificarStatus(float media){
        String status;
        if(media >= 7){
            status = "Aprovado!";
        } else if(media <= 4){
            status = "Reprovado!";
        } else{
            status = "Prova final!";
        }
        
        return status;
    }
    
    public static void exibirAlunos(int id){
        System.out.println("Nome do aluno: "+nomeAluno[id]);
        System.out.println("Nota da AV1: "+notaAv1[id]);
        System.out.println("Nota da AV2: "+notaAv2[id]);
        calcularMedia(notaAv1[id], notaAv2[id]);
    }
    
}