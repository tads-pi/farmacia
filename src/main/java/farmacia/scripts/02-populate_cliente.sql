INSERT INTO
    tb_cliente (
        nome,
        email,
        cpf,
        endereco,
        numero_de_telefone,
        genero,
        estado_civil,
        data_de_nascimento
    )
VALUES
    (
        "Teste Teste",
        "email@example.com",
        "012.345.678-90",
        "Rua Tal Tal Tal, Nº 50",
        "(11)91234-5678",
        "-",
        "Solteiro(a)",
        CURRENT_TIMESTAMP
    );
