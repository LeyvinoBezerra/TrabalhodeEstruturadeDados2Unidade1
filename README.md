# Prática Offline 1 — Estrutura de Dados II

**Universidade Federal Rural do Semi-Árido – UFERSA**  
**Centro de Ciências Exatas e Naturais – CCEN**  
**Departamento de Computação – DC**  
**Graduação em Ciência da Computação**  
**Disciplina:** Estrutura de Dados II  
**Professor:** Paulo Henrique Lopes Silva  

---

## 📝 Tema

**Indexação em Bancos de Dados**

---

## 1. O que é Indexação?

- Indexação envolve criar estruturas auxiliares (índices) para localizar registros rapidamente.
- Assim como o índice de um livro, evita percorrer toda a base de dados em busca de um item.

---

## 2. Armazenamento em Bancos de Dados

### 📁 Armazenamento Físico
- Dados são gravados em blocos/páginas de disco.
- Inserções e remoções podem gerar fragmentação.

### 📄 Armazenamento Lógico (sem índice)
- O banco realiza uma varredura completa para localizar registros (full table scan).

---

## 3. Árvores Binárias Balanceadas

- Árvores desbalanceadas podem ter desempenho O(n).
- Árvores como AVL, Rubro-Negra, B e B+ mantêm altura logarítmica:  
  - Busca eficiente `O(log n)`
  - Inserção e remoção rápidas
  - Ordenação natural dos dados

---

## 4. Indexação com Árvores

### 🧱 Criação do Índice

- O banco cria uma árvore balanceada (ex: AVL) com a coluna indexada.
- Cada nó contém:
  - A chave (ex: ID, CPF)
  - Referência ao registro original

### 🔍 Busca com Índice

- A árvore é navegada da raiz ao nó correspondente.
- O ponteiro leva diretamente ao dado armazenado.

---

## 5. Simulação: Monitoramento Ambiental

### 🌡 Cenário

- Dispositivos remotos com sensores coletam temperatura, umidade e pressão.
- Dados são enviados a um servidor e armazenados em uma **lista ligada**.
- Uma **árvore AVL** funciona como índice lógico.

### 🧾 Estruturas

#### `RegistroClimatico`

```java
int idRegistro;
String idDispositivo;
LocalDateTime dataHora;
double temperatura;
double umidade;
double pressao;
RegistroClimatico proximo;
