let numeroSecreto = 0;
let intentos = 0;
let listaNumerosSorteados = [];
let numeroMaximo = 10;

console.log(numeroSecreto);

function asignarTextoElemento(elemento, texto) {
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
    return;
}

function verificarIntento() {
    let numeroDeUsuario = parseInt(document.getElementById('valorUsuario').value);
    
    if (numeroDeUsuario === numeroSecreto) {
        asignarTextoElemento('p',`Acertaste el número! en ${intentos} ${(intentos === 1) ? 'vez' : 'veces'} `);
        document.getElementById('reiniciar').removeAttribute('disabled');
    } else {
        /*El usuario no acerto*/
        if (numeroDeUsuario > numeroSecreto) {
            asignarTextoElemento('p','El número secreto es menor!');
        } else {
            asignarTextoElemento('p','El número secreto es mayor');
        }
        intentos++;
        limpiarCaja();
    }
    return;
}

/*Queryselector por ID*/
function limpiarCaja()  {
    let valorCaja = document.querySelector('#valorUsuario');
    valorCaja.value = '';
}

//Si ya sorteamos todos los numeros del rango
if (listaNumerosSorteados.length == numeroMaximo) {
    asignarTextoElemento('p', 'YA SE SORTEARON TODOS LOS NÚMEROS POSIBLES')
}else{
    function generarNumeroSecreto() {
        let numeroGenerado = Math.floor(Math.random()*numeroMaximo)+1;
        //Si el numero generado esta incluido en la lista hacemos algo sino hacemos otra cosa
        if (listaNumerosSorteados.includes(numeroGenerado)) {
            return generarNumeroSecreto();
        }else{
            listaNumerosSorteados.push(numeroGenerado);
            return numeroGenerado;
        }
}


function condicionesIniciales() {
    asignarTextoElemento('h1','Hora del Desafío!');
    asignarTextoElemento('p',`Indica un número del 1 al ${numeroMaximo}`);
    numeroSecreto = generarNumeroSecreto();
    intentos = 1;
}

function reiniciarJuego() {
    //limpiar la caja
    limpiarCaja();
    //indicar mensaje de inicio
    //generar el numero aleatorio
    //reinicializar numero intentos
    condicionesIniciales();
    //desabilitar boton nuevo juego
    document.querySelector('#reiniciar').setAttribute('disabled', true);
}

condicionesIniciales();