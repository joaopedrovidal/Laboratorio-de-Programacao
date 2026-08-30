#   03 - Lista de atividades (Extra)
Criar um sistema bancário simples, onde será possível criar uma conta (com agência, banco e tipo) e realizar operações financeiras, como creditar, debitar, consultar o saldo e encerrar a conta. Utilize try/catch e outros métodos de proteção das entradas, similar ao exercício do "Bichinho Virtual". O programa se encerra quando o usuário encerrar a conta.

No sistema bancário brasileiro todas as contas possuem um número, um agência (nome e número), o banco (nome e número), o tipo (número indicando 1=corrente, 2=poupança, 3=conjunta, 4=conta encerrada, etc.) e saldo. Com estas contas podem ser feitas as seguintes ações:

abrir: recebe os dados da conta e insere 0 como estado do saldo;
encerrar: caso a conta não tenha saldo negativo, coloca o tipo da conta como 4 e retorna o valor atual do saldo zerando-o em seguida;
consultar_saldo: retorna o valor atual do saldo;
creditar: caso a conta não esteja encerrada, adiciona o valor recebido no parâmetro no estado saldo;
debitar: caso a conta não esteja encerrada, retira o valor recebido como parâmetro do estado saldo.
Crie um pacote com o nome de “exBanco” e, depois, crie a primeira classe chamada de “Application”, com a opção de gerar o public static void main selecionada. Crie também a classe de “Banco”, que será a nossa classe onde teremos todos os métodos e ações relacionados ao banco, defina os atributos que as contas possuem: numero, ag_numero, ag_nome, tipo e saldo.

Crie o Construtor padrão, conforme no exercício anterior. E depois, crie um construtor com saldo inicial igual a 0, e crie os getters .

Crie os métodos específicos creditar, consultarSaldo, encerrarConta e textoEncerrar. O método creditar vai receber o saldo como incremento, creditando um valor a mais na conta, que será inserido pelo usuário. O método debitar irá decrementar um determinado valor que o usuário inserir. O método consultarSaldo pede o número da conta e retorna uma mensagem com a conta e seu respectivo saldo. O método encerrarConta coloca o tipo da conta como 4 e retorna este número (número de conta encerrada). O método textoEncerrar exibe uma mensagem com o número da conta, o tipo e o saldo que foi encerrada.

Na classe Application, declare o Scanner, para o usuário digitar valores e crie uma variável op com o valor de 0 (tipo int). Crie também um método try/catch genérico para evitar alguns erros, lançando uma exceção caso seja encontrado algum problema. No finally, coloque para fechar o Scanner, com sc.close().

Instancie um novo objeto Conta utilizando o construtor personalizado criado, informando 1 para número da conta, 100 para número da agência, Sede para nome da agência e 1 para tipo de conta. O saldo será carregado com o valor de 0. Crie também um laço while, que será executado até o usuário escolher a opção 4 ou 5, utilizando a variável op que criamos lá em cima. Deverá ser exibida uma mensagem contendo um menu para o usuário escolher (1-Creditar, 2-Debitar, 3-Consultar Saldo, 4-Encerrar Conta e 5-Sair). Caso seja inserido um número fora destes, o sistema vai gerar uma mensagem de erro e mostrar o menu novamente.

Implemente o switch, que vai utilizar o valor da variável op.

Para o valor igual a 1 ou 2, utilize um if para verificar se o tipo de conta é diferente de 4 (conta encerrada), exibindo uma mensagem de erro caso seja true.

O caso 1 irá convocar o método creditar e depois informar o novo saldo,
o mesmo ocorre no caso 2, onde convoca o método debitar e exibe o novo saldo,
No caso 3, o sistema apenas exibe o saldo inovando o método getSaldo,
No caso 4, o sistema verifica se o saldo é negativo e se true, não permite encerrar a conta, do contrário, convoca o método encerrarConta e o método textoEncerrar, que exibirá aquela mensagem personalizada que criamos na classe Bank,
E, por fim, o caso 5 encerra o programa.
Dentro do if (que está testando os valores de op), utilize um switch para o usuário digitar uma opção e convocar o seu respectivo método do objeto c1. Caso o usuário escolha a opção 5, o programa será encerrado.

Entrega pelo GitHub
A entrega da atividade será realizada exclusivamente pelo GitHub.
Após criar o repositório, você deverá adicionar o professor (@eduardofelicianojr) ao projeto. 