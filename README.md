# Gerador de CPFs e CNPJs

Este é um projeto Java que implementa uma API para gerar CPFs e CNPJs válidos de forma aleatória. A API foi desenvolvida usando o framework AWS Lambda e API Gateway da Amazon Web Services (AWS).

## Funcionalidades

- Geração de CPFs válidos.
- Geração de CNPJs válidos.

## Como usar

### Gerar CPF

Para gerar um CPF aleatório, faça uma requisição GET para o endpoint `/generate-cpf`. Por exemplo:

```
https://czihgc8hvg.execute-api.us-east-1.amazonaws.com/dev/generate-cpf?type=cpf
```

Isso retornará um CPF aleatório no formato `XXX.XXX.XXX-XX`.

### Gerar CNPJ

Para gerar um CNPJ aleatório, faça uma requisição GET para o endpoint `/generate-cpf?type=cnpj`. Por exemplo:

```
https://czihgc8hvg.execute-api.us-east-1.amazonaws.com/dev/generate-cpf?type=cnpj
```

Isso retornará um CNPJ aleatório no formato `XX.XXX.XXX/XXXX-XX`.

---

Adicione mais informações conforme necessário para descrever melhor o seu projeto e como utilizá-lo.
