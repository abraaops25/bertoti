#### 1. Primeiro trecho sobre Engenheiro de Software at Google, Oreilly
   
Para o Google existem diferenças entre um "Programador" e um "Engenheiro de Software". Onde estudantes de universidades tendem a estudar a ciencia da computação e conseguindo trabalhos como "Programadores".
Ja Engenheiros de Software como algo mais serio. O google nos mostra que mesmo outros "Engenheiros" tem métodos mais rigorosos pois implicam danos reais, diferente dos Engenheiros de Software onde não tem muitas praticas rigorosas, e este é um dos principais objetivos do Livro, para que ajude a ter mais metodos rigoroso, e praticas confiaveis

#### 2. Segundo trecho sobre Engenheiro de Software at Google, Oreilly

Segundo o trecho, com o tempo os "engenheiros de Software" abrangiam não somente o ato de escrever codigos, mas tambem todas as ferramentas e os processos de organização utilizadas para a manutenção do codigo com o tempo. O Google espera que com sua experiencia de mais de 2 decadas possa passar ideias de como manter a organização e manutenção de codigos com o passar do tempo, utilizando de 3 Pricipios Fundamentais que eles sentem que as organizações de software devem manter em mente.

 - 1 - Tempo e Mudança:
 - 2 - Escala 
 - 3 - Crescimento



  Citando 3 Exemplos de Trade-Offs

**1. Desempenho vs. Manutenibilidade (Código Simples vs. Otimizado)**
O Dilema: Desenvolver código simples e legível (alta manutenibilidade) geralmente é melhor para a saúde do projeto a longo prazo. No entanto, códigos altamente otimizados para performance (menor latência, maior throughput) costumam ser complexos, obscuros e difíceis de manter.
Trade-off: Escrever um algoritmo complexo (ex: uso intensivo de bitwise operations ou cache manual) pode aumentar a velocidade, mas sacrifica a facilidade com que novos desenvolvedores entendem e alteram o código.

**2. . Espaço vs. Tempo (Memória vs. Processamento)**
O Dilema: Frequentemente, é possível acelerar a execução de um sistema gastando mais memória, ou economizar memória tornando a execução mais lenta.
Trade-off:
Tempo (mais rápido): Usar Caching (como Redis) ou pré-computar resultados. Consome mais memória/disco.
Espaço (mais compacto): Recomputar dados sob demanda ou usar compressão de dados. Consome mais CPU.

**3. Consistência vs. Disponibilidade (CAP Theorem)**
O Dilema: Em sistemas distribuídos (microsserviços/bancos de dados NoSQL), durante uma falha de rede (partição), você deve escolher entre garantir que todos os nós tenham dados idênticos (Consistência) ou que o sistema continue respondendo (Disponibilidade).
Trade-off:
Consistência Forte: O usuário recebe erro ou o sistema trava enquanto os dados não são sincronizados (ex: transações bancárias).
Alta Disponibilidade (Consistência Eventual): O sistema aceita a escrita, mas o usuário pode ver dados desatualizados temporariamente (ex: redes sociais, carrinhos de compras.



#### 3. Os 5 Requisitos não funcionais

1 Segurança - Os dados dos usuários devem ser criptografados.
2 Usabilidade - O sistema deve ser compatível com dispositivos móveis (Android e iOS).
3 Agilidade - descrevem como o sistema deve funcionar, definindo atributos de qualidade, restrições técnicos e de performance, como velocidade, segurança e usabilidade, em vez de funcionalidades específicas 
4 Performance - O tempo de resposta para buscas não deve exceder 2 segundos
5 Consistência - garantia de que os dados e processos de um sistema permaneçam uniformes, coerentes e precisos em todos os seus componentes, módulos e réplicas, mesmo após atualizações ou em cenários de distribuição (múltiplos servidores)



#### 4. Trade-offs (negociação entre requisitos não funcionais)

 **1. Negócios:** Qualidade vs. Custo (ou Velocidade)
Em produção ou gestão de projetos, é raro conseguir a mais alta qualidade, o menor preço e a entrega mais rápida ao mesmo tempo.
O Trade-off: Se uma empresa decide aumentar drasticamente a qualidade do produto (matéria-prima superior, mais inspeções), ela provavelmente aumentará o custo de produção ou reduzirá a velocidade de entrega. Um exemplo disso é a plataforma de jogos Riot aumentando a qualidade, reduzimdo a velocidade de entrega para algumas maquinas;
**A escolha:** Produzir um item premium, caro e mais lento, OU um item barato, rápido, mas de qualidade padrão.

**2. Pessoal:** Tempo vs. Dinheiro (Trabalho vs. Lazer)
Um dos trade-offs mais comuns na vida diária é a alocação de tempo para geração de renda versus qualidade de vida.
O Trade-off: Dedicar mais horas ao trabalho aumenta a renda (dinheiro), mas reduz o tempo livre (lazer) para família, hobbies ou descanso.
Assim como a maioria dos trabalhadores comuns.
 **A escolha:** Fazer horas extras para comprar algo (ganha dinheiro, perde tempo) OU recusar horas extras para descansar (ganha tempo, perde dinheiro)

 **3. Logística:** Nível de Serviço vs. Custos de Inventário
Na cadeia de suprimentos, as empresas precisam decidir como atender o cliente sem falir.
O Trade-off: Aumentar o nível de serviço (ter todos os produtos prontos para entrega imediata) exige altos custos de inventário (estoque alto e caro) e alto custo de armazenagem. Assim como Mercado Livre fez atualmente, aumentando sua capacidade de armazenamento.
**A escolha:** Manter estoque alto (cliente satisfeito, mas alto custo operacional) OU manter estoque baixo (reduz custos, mas arrisca não ter produto para vender - ruptura)


#### 5. É possivel testar tudo?
```C#
int bleach ( int j) {
j = j-1 // deveria ser j = + 1
j = j / 30.000
return j;
}
```

Amostragem: -32.768 até +32.767


**1.** Quantas entradas mostram o erro?
R: 4

**2.** Quais são?
   R: 30,000; -30.000; -29.999; 29.999
