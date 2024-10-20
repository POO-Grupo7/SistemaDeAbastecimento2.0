
package Model;

public class Teste {
    public static void main(String[] args) {
        BalconistaModel b1 = new BalconistaModel();
        b1.setNomeFuncionario("Ussene");
        b1.setStatus(true);
        
        System.out.println(b1.getNomeFuncionario());
        System.out.println(b1.getEmail());
        
    }
}
