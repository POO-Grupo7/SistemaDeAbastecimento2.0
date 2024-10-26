package Model;

import java.util.Date;

public class Teste {

    public static void main(String[] args) {

        //Cliente 1
        ClienteModel cli1 = new ClienteModel();
        cli1.setNome("Maria");
        cli1.setApelido("Joao");
        cli1.setQuarteirao(21);
        cli1.setNrDaCasa(165);
        cli1.setSaldo(2000);

        //Cliente 2
        ClienteModel cli2 = new ClienteModel();
        cli2.setNome("Jerry");
        cli2.setApelido("Matato");
        cli2.setQuarteirao(10);
        cli2.setNrDaCasa(255);
        cli2.setSaldo(500);

        //Hidrometro 1
        HidrometroModel hidro1 = new HidrometroModel();
        hidro1.setIdHidrometro(01);
        hidro1.setNrHiodrometro("202001");

        //Hidrometro 2
        HidrometroModel hidro2 = new HidrometroModel();
        hidro2.setIdHidrometro(02);
        hidro2.setNrHiodrometro("202015");

        //Historico do hidrometro 1
        HistoricoHidrometroModel histHidro1 = new HistoricoHidrometroModel();
        histHidro1.setDataInicial("01/01/2020");
        histHidro1.setHidrometro(hidro1);
        histHidro1.setCliente(cli1);
        cli1.adicionarHistoricoHidrometro(histHidro1);
        hidro1.adicionarHistoricoHidrometro(histHidro1);

        //Historico do hidrometro 2
        HistoricoHidrometroModel histHidro2 = new HistoricoHidrometroModel();
        histHidro2.setDataInicial("12/11/2022");
        histHidro2.setHidrometro(hidro2);
        histHidro2.setCliente(cli1);
        cli1.adicionarHistoricoHidrometro(histHidro2);
        hidro2.adicionarHistoricoHidrometro(histHidro2);

//        System.out.println("Historico do hidrometro\n");
//        System.out.println(histHidro1.imprimir());
        for (int i = 0; i < cli1.quantidadeHistoricoHidrometro(); i++) {
            System.out.println(cli1.getHistoricoHidrometro(i).imprimir());
        }

        System.out.println("\nDatas dos incio de uso dos hidrometros");
        for (int i = 0; i < cli1.quantidadeHistoricoHidrometro(); i++) {
            System.out.println(cli1.getHistoricoHidrometro(i).getDataInicial());
        }
    }
}
