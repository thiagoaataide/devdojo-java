package br.com.devdojo.javacore.introducaometodos.classes;
// Crie os seguintes atributos para essa classe
    //Nome
    //Matricula
    //rg
    //cpf
//Crie uma classe de teste para preencher e imprimir os dados desse professor

/* DevDojo
Aulas 31 e 32 - Método com Parâmetro tipo Reference e This
* */
public class Professor {
    public String nome;
    public String matricula;
    public String rg;
    public String cpf;

    /*Para evitar a repetição será criado um método para retornar o objeto*/
//    public void imprime(Professor prof){
//        System.out.println("-------------------------");
//        System.out.println("Endereço de Memória: " + prof);
//        System.out.println(prof.cpf);
//        System.out.println(prof.matricula);
//        System.out.println(prof.nome);
//        System.out.println(prof.rg);
//        prof.nome = "Outro nome";
//        System.out.println(prof.nome);
//    }

    /*Utilização do "this". Como estou dentro do objeto não preciso especificar a referencia e a caracteristica.
    É possível chamar os atributos do objeto com a palavra this.*/
    public void imprime(){
        System.out.println("-------------------------");
//        System.out.println("Endereço de Memória: " + prof);
        System.out.println(this.cpf);
        System.out.println(this.matricula);
        System.out.println(this.nome);
        System.out.println(this.rg);
    }


}
