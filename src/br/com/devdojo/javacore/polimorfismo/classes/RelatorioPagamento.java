package br.com.devdojo.javacore.polimorfismo.classes;

public class RelatorioPagamento {
//    public void relatorioPagamentoGerente(Gerente gerente){
//        System.out.println("Gerando relatório de pagamento para gerência!");
//        gerente.calcularPagamento();
//        System.out.println("Nome: " + gerente.getNome());
//        System.out.println("Salário: " + gerente.getSalario());
//    }
//
//    public void relatorioPagamentoVendedor(Vendedor vendedor){
//        System.out.println("Gerando relatório de pagamento para vendedores!");
//        vendedor.calcularPagamento();
//        System.out.println("Nome: " + vendedor.getNome());
//        System.out.println("Salário: " + vendedor.getSalario());
//    }

    public void relatorioPagamentoGenerico(Funcionario funcionario){
        System.out.println("Gerando relatório de pagamento");
        funcionario.calcularPagamento();
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salário: " + funcionario.getSalario());
        if(funcionario instanceof Gerente) {
            Gerente g = (Gerente) funcionario;
            System.out.println("PNL: " + g.getPnl());
        }

        if(funcionario instanceof Vendedor){
//            Vendedor v = (Vendedor) funcionario;
//            System.out.println("Total de Vendas: " + v.getTotalVendas());
            System.out.println("Total de Vendas: " + ((Vendedor) funcionario).getTotalVendas());
        }
    }
}
