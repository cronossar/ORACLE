// //Variables
// let numeroSecreto = 2;
// let numeroUsuario = prompt("Me indicas un número entre 1 y 10 por favor:");

// console.log(numeroUsuario);
// /*
// Este código realiza
// la comparación
// */
// if (numeroUsuario == numeroSecreto) {
//     //Acertamos, fue verdadera la condición
//     alert(`Acertaste, el número es: ${numeroUsuario}`);
// } else {
//     //La condición no se cumplió
//     alert('Lo siento, no acertaste el número');
// }


// Desafíos:

// Pregunta al usuario qué día de la semana es. Si la respuesta es "Sábado" o "Domingo",
// muestra "¡Buen fin de semana!". De lo contrario, muestra "¡Buena semana!".
// let dia = prompt('¿QUE DIA DE LA SEMANA ES HOY?');
// if (dia == 'Sabado' || dia == 'Domingo' || dia == 'sabado' || dia == 'domingo' ||
//     dia == 'SABADO' || dia == 'DOMINGO') {
//     alert('BUEN FIN DE SEMANA');
// } else {
//     alert('BUENA SEMANA');
// }

// Verifica si un número ingresado por el usuario es positivo o negativo.
// Muestra una alerta informativa.
// let numero = prompt('INGRESA UN NUMERO ENTRE 10 Y -10');
// if (numero >=0) {
//     alert('El numero es positivo ' + ' escribiste el: ' + numero);
// } else {
//     alert('El numero es negativo ' + ', escribiste el: ' + numero);
// }

// Crea un sistema de puntuación para un juego. Si la puntuación es mayor o igual a 100,
// muestra "¡Felicidades, has ganado!". En caso contrario, muestra "Intentalo nuevamente para ganar.".





// Crea un mensaje que informe al usuario sobre el saldo de su cuenta, utilizando un
// template string para incluir el valor del saldo.




// Pide al usuario que ingrese su nombre mediante un prompt. Luego, muestra una alerta de
// bienvenida usando ese nombre.


// Juego de numeroSecreto
// Al usar Floor quitamos decimales y si al final ponemos +1 eliminamos al cero de la operacion
// puedo usar parseInt para pedir solo enteros
//let numeroSecreto = Math.floor(Math.random()*10)+1;
let numeroSecreto = parseInt(Math.random()*maximoPosible)+1;
let numeroUsuario = 0;
let intentos = 1;
let palabraVeces = 'vez' //para arreglar como muestra la palabra segun cantidad de intentos
let maximosIntentos = 6;
let maximoPosible = 100;

console.log(numeroSecreto);

while (numeroUsuario != numeroSecreto) {
numeroUsuario = parseInt(prompt(`Me indicas un numero entre 1 y ${maximoPosible}, por favor`));

console.log(numeroUsuario);

/*Este codigo realiza la comparacion */

if (numeroUsuario == numeroSecreto) {
//Acertamos, fue correcta la eleccion
//operador ternario
    alert(`Acertaste, el numero es:  ${numeroUsuario}. Lo hiciste en:  ${intentos} ${intentos == 1 ? 'vez' : 'veces'}`);

}else{
    if (numeroUsuario > numeroSecreto) {
    alert(`El numero secreto es menor.`);
    }else{
    alert(`El numero secreto es mayor.`);
}
//intentos = intentos + 1;
//intentos +=1;
intentos ++
//palabraVeces = 'veces';

    if (intentos > 3) {
        alert(`Alcanzaste el numero máximo de ${maximosIntentos} intentos`);
        break
    }
}
}


// let contador = 1;

// while (contador < 4) {
//   console.log('Ejecutando la iteración ' + contador);
//   contador = contador + 1;
// }

// Crea un contador que comience en 1 y vaya hasta 10 usando un bucle 'while'. Muestra cada número.


// Crea un contador que comience en 10 y vaya hasta 0 usando un bucle 'while'. Muestra cada número.


// Crea un programa de cuenta progresiva. Pide un número y cuenta desde 0 hasta ese número utilizando
//  un bucle 'while' en la consola del navegador.


// Crea un programa de cuenta progresiva. Pide un número y cuenta desde 0 hasta ese número utilizando
//  un bucle 'while' en la consola del navegador.

//  Crea un programa que utilice console.log para mostrar un mensaje de bienvenida.

//  Crea una variable llamada "nombre" y asígnale tu nombre. Luego, utiliza console.log 
//  para mostrar el mensaje "¡Hola, [tu nombre]!" en la consola del navegador.

//  Crea una variable llamada "nombre" y asígnale tu nombre. Luego, utiliza alert para mostrar
//   el mensaje "¡Hola, [tu nombre]!".

//  Utiliza prompt y haz la siguiente pregunta: ¿Cuál es el lenguaje de programación que más te gusta?.
//   Luego, almacena la respuesta en una variable y muestra la respuesta en la consola del navegador.

//  Crea una variable llamada "valor1" y otra llamada "valor2", asignándoles valores numéricos de tu elección.
//   Luego, realiza la suma de estos dos valores y almacena el resultado en una tercera variable llamada "resultado". Utiliza console.log para mostrar el mensaje "La suma de [valor1] y [valor2] es igual a [resultado]." en la consola.

//  Crea una variable llamada "valor1" y otra llamada "valor2", asignándoles valores numéricos de tu elección. Luego, realiza la resta de estos dos valores y almacena el resultado en una tercera variable llamada "resultado". Utiliza console.log para mostrar el mensaje "La diferencia entre [valor1] y [valor2] es igual a [resultado]." en la consola.

//  Pide al usuario que ingrese su edad con prompt. Con base en la edad ingresada, utiliza un if 
//  para verificar si la persona es mayor o menor de edad y muestra un mensaje apropiado en la consola.

//  Crea una variable "numero" y solicita un valor con prompt. Luego, verifica si es positivo, 
//  negativo o cero utilizando un if-else y muestra el mensaje correspondiente.

//  Utiliza un bucle while para mostrar los números del 1 al 10 en la consola.

//  Crea una variable "nota" y asígnale un valor numérico. Utiliza un if-else para determinar
//   si la nota es mayor o igual a 7 y muestra "Aprobado" o "Reprobado" en la consola.

//  Utiliza Math.random para generar cualquier número aleatorio y muestra ese número en la consola.

//  Utiliza Math.random para generar un número entero entre 1 y 10 y muestra ese número en la consola.

//  Utiliza Math.random para generar un número entero entre 1 y 1000 y muestra ese número en la consola.