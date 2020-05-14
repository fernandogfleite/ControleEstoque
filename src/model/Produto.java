
package model;


public class Produto {
    private int idProduto;
    private String nomeProduto;
    private double valorProduto;
    private int qntdProduto;

    public Produto(int idProduto, String nomeProduto, double valorPorduto, int qntdProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorPorduto;
        this.qntdProduto = qntdProduto;
    }

    public Produto(String nomeProduto, double valorProduto, int qntdProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.qntdProduto = qntdProduto;
    }

    public Produto(int idProduto, int qntdProduto) {
        this.idProduto = idProduto;
        this.qntdProduto = qntdProduto;
    }

    public Produto() {
        
    }

    
    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the valorPorduto
     */
    public double getValorProduto() {
        return valorProduto;
    }

    /**
     * @param valorProduto the valorProduto to set
     */
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    /**
     * @return the qntdProduto
     */
    public int getQntdProduto() {
        return qntdProduto;
    }

    /**
     * @param qntdProduto the qntdProduto to set
     */
    public void setQntdProduto(int qntdProduto) {
        this.qntdProduto = qntdProduto;
    }
    
}
