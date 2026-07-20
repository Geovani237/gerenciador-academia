# Sistema de Gerenciamento de Academia

Proposta: sistema simples para cadastrar alunos, montar treinos, registrar presença e controlar mensalidades de uma academia.

### Jornada 1: Cadastro de Aluno
```
Aluno chegou na academia
↓
Atendente informou nome, telefone, objetivo e plano desejado
↓
Sistema validou dados obrigatórios
↓
Sistema criou matrícula
↓
Aluno ficou ativo no sistema
```

### Jornada 2: Montagem de Treino
```
Instrutor selecionou um aluno
↓
Instrutor definiu objetivo do treino
↓
Instrutor adicionou exercícios, séries e repetições
↓
Sistema validou exercícios duplicados
↓
Treino foi salvo
↓
Aluno pôde visualizar o treino
```

### Jornada 3: Check-in na Academia
```
Aluno informou matrícula na entrada
↓
Sistema verificou se o plano estava ativo
↓
Sistema registrou check-in
↓
Acesso foi liberado
↓
Histórico de presença foi atualizado
```

### Jornada 4: Pagamento de Mensalidade
```
Aluno consultou mensalidade em aberto
↓
Sistema exibiu valor e vencimento
↓
Pagamento foi registrado
↓
Sistema atualizou status da mensalidade
↓
Plano permaneceu ativo
```

### Jornada 5: Bloqueio por Atraso
```
Sistema verificou mensalidades vencidas
↓
Sistema identificou atraso acima do limite
↓
Matrícula foi bloqueada
↓
Aluno tentou realizar check-in
↓
Sistema negou acesso e exibiu motivo
```

