public class Emergency {
    
    private String nome;
    private int telefone;
    private String local;
    private String dataEhora;
    private String naturezaDaOcorrencia;
    private String tipo;
    private String statusResposta;
    
    public Emergency(String nome, int telefone, String local, String dataEhora, String naturezaDaOcorrencia, String tipo, String statusResposta){
        this.nome = nome;
        this.telefone = telefone;
        this.local = local;
        this.dataEhora = dataEhora;
        this.naturezaDaOcorrencia = naturezaDaOcorrencia;
        this.tipo = tipo;
        this.statusResposta = statusResposta;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    public int getTelefone(){
        return telefone;
    }
    
    public void setLocal(String local){
        this.local = local;
    }
    public String getLocal(){
        return local;
    }
    
    public void setDataEHora(String dataEhora){
        this.dataEhora = dataEhora;
    }
    public String setDataEHora(){
        return dataEhora;
    }
    
    public void setNaturezaDaOcorrencia(String naturezaDaOcorrencia){
        this.naturezaDaOcorrencia = naturezaDaOcorrencia;
    }
    public String setNaturezaDaOcorrencia(){
        return naturezaDaOcorrencia;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String setTipo(){
        return tipo;
    }
    
    public void setStatusResposta(String statusResposta){
        this.statusResposta = statusResposta;
    }
    public String setStatusResposta(){
        return statusResposta;
    }
    
    public void displayEmergencyDetails() {
        System.out.println("Detalhes da Emergência:");
        System.out.println("Nome do Relator: " + nome);
        System.out.println("Telefone do Relator: " + telefone);
        System.out.println("Localização da Emergência: " + local);
        System.out.println("Data/Hora do Relatório: " + dataEhora);
        System.out.println("Natureza da Emergência: " + naturezaDaOcorrencia);
        System.out.println("Tipo de Resposta: " + tipo);
        System.out.println("Status da Resposta: " + statusResposta);
    }

}