/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudantes;

/**
 *
 * @author luizscolari
 */
public class EstudanteDeGraduacao extends Estudante{
    
    private String cargo;
    
    public EstudanteDeGraduacao(String nome, String cargo){
        super(nome);
        this.cargo = cargo;
    }
    public EstudanteDeGraduacao(String nome){
        super(nome);
        this.cargo = "";
    }
    
    /**
     * @return the nome
     */
    @Override
    public String getNome() {
        String nome = super.getNome();
        return getCargo() + " " + nome;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String getOrientado() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
