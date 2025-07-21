# 🎲 Simulador de Rolagem de Dados RPG — Java

Este programa simula rolagens de dados em estilo RPG (`DnD`, `Call of Cthulhu`, etc.), permitindo que o usuário digite comandos como `2d6+3` ou `1d20-1`. Ele gera os valores aleatórios de acordo com o tipo de dado e mostra a soma total com modificadores.

---

## 🚀 Como usar

1. Compile o código:

   ```bash
   javac Main.java

2. Execute:

        java Main


3. Digite comandos como:

    1d20 → Rola 1 dado de 20 lados

    3d6 → Rola 3 dados de 6 lados

    2d10+2 → Rola 2 dados de 10 lados, somando +2 ao total

    4d4-1 → Rola 4 dados de 4 lados, subtraindo 1 do total

4. Digite ```Sair``` para encerrar o programa.

## Regras do Programa

Apenas dados com número de lados par e maior que 1 são aceitos.

A entrada precisa seguir o formato:

[quantidade]d[lados][+ou-modificador]

Ex: `2d6`, `3d8+1`, `1d20-5`.

##  Exemplo de saída

*Digite a rolagem no formato RPG (ex: 3d6, 2d10+1, 1d20-2), ou 'sair' para encerrar.*

Sua rolagem:
- 2d6+1
- Rolando...
- Dado 1: 3
- Dado 2: 4
- Total com modificador (+1): 8
---
## Explicação do Regex

A linha abaixo interpreta a entrada do usuário:

`Pattern pattern = Pattern.compile("(\\d+)d(\\d+)([+-]\\d+)?");`

| Pedaço       | Significado                                       | Exemplo (`2d6+3`) |
| ------------ | ------------------------------------------------- | ----------------- |
| `(\d+)`      | Grupo 1: quantidade de dados (um ou mais dígitos) | `2`               |
| `d`          | Letra "d" fixa entre quantidade e lados           | `d`               |
| `(\d+)`      | Grupo 2: quantidade de lados do dado              | `6`               |
| `([+-]\d+)?` | Grupo 3: modificador opcional (como +3 ou -1)     | `+3`              |

## Lógica Principal

1. O programa usa `Scanner` para receber a entrada do usuário.
    
2. Com `Pattern` e `Matcher`, ele verifica se a entrada bate com o formato.
    
3. Se for válida:
    
    - Rola os dados com `Random.nextInt(lados) + 1`
        
    - Soma todos os valores e adiciona (ou subtrai) o modificador
        
    - Exibe o total final

## Boas práticas usadas

- Validação de entrada com **Regex**
    
- Verificação de valores inválidos
    
- Fechamento do `Scanner` com `sc.close()`

## Expansões possíveis

Este projeto pode ser facilmente expandido para:

- Simuladores de combate RPG
    
- Ferramentas de criação de fichas de personagens
    
- Geradores de rolagens automáticas com vantagens, críticos, etc.




