package entities;

public final class PessoaFisica extends Pessoa {

    private Double gastosComSaude;

    public PessoaFisica(){
        super();
    }

    public PessoaFisica(String name, Double rendaAnual, Double gastosComSaude){
        super(name, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    public Double getGastosComSaude(){
        return  this.gastosComSaude;
    }

    public void setGastosComSaude(Double gastosComSaude){
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public Double calculaImpostos(){
        if(getRendaAnual() < 20000.00){
            return  getRendaAnual()*0.15 - getGastosComSaude()*0.5;
        }
        else{
            return  getRendaAnual()*0.25 - getGastosComSaude()*0.5;
        }
    }

}
