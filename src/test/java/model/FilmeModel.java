package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmeModel {

    private Integer codigo;
    private String nome;
    private String sinopse;
    private String faixaEtaria;
    private String genero;

    public FilmeModel(Integer codigo, String nome, String snopse, String faixaEtaria, String genero) {
        this.codigo = codigo;
        this.nome = nome;
        this.sinopse = snopse;
        this.faixaEtaria = faixaEtaria;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "{\n" +
                "        \"codigo\": "+ codigo +",\n" +
                "        \"nome\": \""+ nome +"\",\n" +
                "        \"sinopse\": \""+ sinopse + "\",\n" +
                "        \"faixaEtaria\": \"" + faixaEtaria + "\",\n" +
                "        \"genero\": \""+ genero + "\"\n" +
                "    }";
    }
}
