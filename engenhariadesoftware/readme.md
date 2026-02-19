1. Primeiro trecho sobre Engenheiro de Software at Google, Oreilly
   
Para o Google existem diferenças entre um "Programador" e um "Engenheiro de Software". Onde estudantes de universidades tendem a estudar a ciencia da computação e conseguindo trabalhos como "Programadores".
Ja Engenheiros de Software como algo mais serio. O google nos mostra que mesmo outros "Engenheiros" tem métodos mais rigorosos pois implicam danos reais, diferente dos Engenheiros de Software onde não tem muitas praticas rigorosas, e este é um dos principais objetivos do Livro, para que ajude a ter mais metodos rigoroso, e praticas confiaveis

2. Segundo trecho sobre Engenheiro de Software at Google, Oreilly

Segundo o trecho, com o tempo os "engenheiros de Software" abrangiam não somente o ato de escrever codigos, mas tambem todas as ferramentas e os processos de organização utilizadas para a manutenção do codigo com o tempo. O Google espera que com sua experiencia de mais de 2 decadas possa passar ideias de como manter a organização e manutenção de codigos com o passar do tempo, utilizando de 3 Pricipios Fundamentais que eles sentem que as organizações de software devem manter em mente.

  1 - Tempo e Mudança:
  2 - Escala 
  3 - Crescimento



  3 Exemplos de Trade-Offs

 1. Desempenho vs. Manutenibilidade (Código Simples vs. Otimizado)
O Dilema: Desenvolver código simples e legível (alta manutenibilidade) geralmente é melhor para a saúde do projeto a longo prazo. No entanto, códigos altamente otimizados para performance (menor latência, maior throughput) costumam ser complexos, obscuros e difíceis de manter.
Trade-off: Escrever um algoritmo complexo (ex: uso intensivo de bitwise operations ou cache manual) pode aumentar a velocidade, mas sacrifica a facilidade com que novos desenvolvedores entendem e alteram o código.

2. . Espaço vs. Tempo (Memória vs. Processamento)
O Dilema: Frequentemente, é possível acelerar a execução de um sistema gastando mais memória, ou economizar memória tornando a execução mais lenta.
Trade-off:
Tempo (mais rápido): Usar Caching (como Redis) ou pré-computar resultados. Consome mais memória/disco.
Espaço (mais compacto): Recomputar dados sob demanda ou usar compressão de dados. Consome mais CPU.

3. Consistência vs. Disponibilidade (CAP Theorem)
O Dilema: Em sistemas distribuídos (microsserviços/bancos de dados NoSQL), durante uma falha de rede (partição), você deve escolher entre garantir que todos os nós tenham dados idênticos (Consistência) ou que o sistema continue respondendo (Disponibilidade).
Trade-off:
Consistência Forte: O usuário recebe erro ou o sistema trava enquanto os dados não são sincronizados (ex: transações bancárias).
Alta Disponibilidade (Consistência Eventual): O sistema aceita a escrita, mas o usuário pode ver dados desatualizados temporariamente (ex: redes sociais, carrinhos de compras.
