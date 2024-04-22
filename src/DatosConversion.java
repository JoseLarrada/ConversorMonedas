public class DatosConversion {
    private String codigo;
    private Double valor;

    public DatosConversion() {
    }

    public DatosConversion(String codigo, Double valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
