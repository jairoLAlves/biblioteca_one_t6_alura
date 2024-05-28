package br.com.th4mz0.biblioteca.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> tClass);
}
