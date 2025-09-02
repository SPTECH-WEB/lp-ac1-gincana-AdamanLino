package school.sptech;

public class Gincana {
    private String nome;
    private Double premio;
    private Integer qtdInscrito;
    private Boolean ativa;

    public Gincana(String nome, Double premio) {
        this.nome = nome;
        this.premio = premio;
        qtdInscrito = 0;
        ativa = true;
    }

    public void inscrever(Integer qtd) {
        if (qtd != null && qtd > 0 && ativa == true) {
            this.qtdInscrito += qtd;
        }
    }

    public Integer remover(Integer qtd) {
        if (qtd != null && this.ativa == true && qtd > 0 && qtd <= this.qtdInscrito) {
            this.qtdInscrito -= qtd;
            return qtd;
        } else {
            return null;
        }
    }

    public Integer desativar() {
        if (ativa == false) {
            return null;
        } else {
            ativa = false;
            Integer qtdInscritoTotal = qtdInscrito;
            qtdInscrito = 0;
            return qtdInscritoTotal;
        }
    }

    public void transferir(Gincana destino, Integer qtdATransferir) {
        if (destino != null && this.ativa == true && destino.ativa == true) {
            if (qtdATransferir != null && qtdATransferir > 0 && qtdATransferir <= this.qtdInscrito) {
                this.qtdInscrito -= qtdATransferir;
                destino.qtdInscrito += qtdATransferir;
            }
        }
    }

    public Boolean reajustarPremio(Double reajuste) {
        // Se reajuste for zero ou negativo ou null, não faz nada e retorna false
        if (reajuste == null || reajuste == 0 || reajuste <= 0) {
            return false;
        } else {
            premio += this.premio * reajuste;
            return true;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public Double getPremio() {
        return this.premio;
    }

    public Integer getQtdInscrito() {
        return this.qtdInscrito;
    }

    public Boolean getAtiva() {
        return ativa == true;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
