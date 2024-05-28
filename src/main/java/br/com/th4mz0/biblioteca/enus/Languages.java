package br.com.th4mz0.biblioteca.enus;

public enum Languages {
    ES("Espanhol", "es"),
    EN("Inglês","en"),
    FR("Francês","fr"),
    PT("Português","pt");

    private String abreviacao;
    private String nomeExtenso;

    public static Languages fromAbreviacao(String text) {
        for (Languages lg : Languages.values()) {
            if (lg.abreviacao.equalsIgnoreCase(text)) {
                return lg;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

    Languages(String nomeExtenso, String abreviacao){
        this.abreviacao = abreviacao;
        this.nomeExtenso = nomeExtenso;
    }

    public static Languages fromExtenso(String text) {
        for (Languages lg : Languages.values()) {
            if (lg.nomeExtenso.equalsIgnoreCase(text)) {
                return lg;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }


    }
