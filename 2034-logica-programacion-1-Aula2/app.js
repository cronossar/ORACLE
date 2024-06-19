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
let dia = prompt('¿QUE DIA DE LA SEMANA ES HOY?');
if (dia == 'Sabado' || dia == 'Domingo' || dia == 'sabado' || dia == 'domingo' || 
    dia == 'SABADO' || dia == 'DOMINGO') {
    alert('BUEN FIN DE SEMANA');
} else {
    alert('BUENA SEMANA');
}

// Verifica si un número ingresado por el usuario es positivo o negativo. 
// Muestra una alerta informativa.
let numero = prompt('INGRESA UN NUMERO ENTRE 10 Y -10');
if (numero >=0) { 
    alert('El numero es positivo ' + ' escribiste el: ' + numero);
} else {
    alert('El numero es negativo ' + ', escribiste el: ' + numero);
}

// Crea un sistema de puntuación para un juego. Si la puntuación es mayor o igual a 100, 
// muestra "¡Felicidades, has ganado!". En caso contrario, muestra "Intentalo nuevamente para ganar.".





// Crea un mensaje que informe al usuario sobre el saldo de su cuenta, utilizando un 
// template string para incluir el valor del saldo.




// Pide al usuario que ingrese su nombre mediante un prompt. Luego, muestra una alerta de 
// bienvenida usando ese nombre.
