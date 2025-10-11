## Lógica do agente:

1. Ao ser construído, os agentes se dividem pelas direções possíveis, utilizando da função "GeraDirecaoAleatoria" para definir sua direção inicial.

2. Caso eventualmente o agente não puder seguir em frente (caso enfrente uma parede ou pedra), é gerada outra direção aleatória.

Os agentes nunca se dividirão.

# Lógica ao receber energia

1. Caso o agente encontre um cogumelo e receba energia, o mesmo envia uma mensagem aos agentes próximos, com as seguintes informações:

1- Comando "seguir";
2- A coordenada X atual;
3- A coordenada Y atual;

2. Ao receber a mensagem com o comando "seguir", os agentes próximos realizam o processo a seguir:

1. Calcula a distância entre a posição atual até a posição do agente que enviou a mensagem;

2. Compara as distâncias entre os eixos X e Y, e se movimenta na direção que a distância for maior.

Essa lógica do comando "seguir" foi reutilizada na lógica de combate.

# Lógica de Combate

1. Caso o agente tiver mais energia que o inimigo, ele irá mandar uma mensagem para os agentes próximos o seguirem.

2. Caso o agente tiver menos energia que o inimigo porém mais da metade que ele, o agente irá ficar parado. Essa condição foi pensada com base no caso que o inimigo também tenha a mesma lógica que o item 1, pois ao ficar parado, o agente irá gastar menos da metade de energia que o inimigo.

3. Caso o agente tiver menos da metade da energia que o inimigo, ele irá fugir do inimigo. Para fugir do inimigo, foi criada a função inverterDirecao, que recebe a direção atual do agente e retorna a direção contrária da mesma.

