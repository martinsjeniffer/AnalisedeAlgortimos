<style>
    h1, h2, h3, p {
        font-family: "Times New Roman", Times, serif;
    }
</style>

### ACH2003 - Introducao a Analise de Algoritmos
### EP1 - Recursividade aplicada à computação gráfica
Jeniffer Florinda Martins da Silva, nusp **10377966**

Neste programa é feito a implementação de dois metodos, o `CurvaKoch` e o `RegionFill`, que respectivamente, implementa o desenho de uma curva de Koch, uma das primeiras curvas fractais a ser descrita, e implementa uma pintura de uma região de uma imagem, respeitando possíveis "bordas" (ou melhor, linhas) na imagem.

Este exercício programa foi feito em Java, juntamente com openJDK com as seguintes versões dos programas:

```bash
openjdk version "1.8.0_272"
OpenJDK Runtime Environment (build 1.8.0_272-8u272-b10-0+deb9u1-b10)
OpenJDK 64-Bit Server VM (build 25.272-b10, mixed mode)
```

Para ver o resultado do programa você deve rodar em um terminal (dentro da respectiva pasta do programa):

```bash
javac Main.java
java -Xss255M Main entrada.txt saida.png
```

O arquivo entrada.txt tem a configuração descrita no enunciado do EP, incluindo o nome das chamadas dos métodos. Dessa maneira, nenhum comentário se faz necessário.

exemplo de arquivo `entrada.txt`:

```
2048 2048 0 0 0
SET_COLOR 0 0 255
KOCH_CURVE 148 1024 1900 1024 5
KOCH_CURVE 1900 1024 148 1024 5
SET_COLOR 210 124 34
REGION_FILL 100 100
```