package br.grupointegrado.book.DTO;


public record UsuarioRequestDTO(
        Integer id_usuario,
        String nome,
        String gmail,
        String senha,
        String cep ) {
}
