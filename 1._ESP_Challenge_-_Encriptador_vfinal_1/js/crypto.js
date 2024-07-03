// Función para encriptar el texto usando cifrado César
function encriptar() {
    const textoOriginal = document.getElementById('texto').value;
    /*document.getElementById('texto').value obtiene el valor del elemento HTML
     con el id "texto". En este caso, captura el texto que el usuario ha ingresado
      en el primer campo de entrada (<input id="texto" type="text">). */

    const clave = 1; // Clave de cifrado (en este caso, desplazamiento de 1 posición)
    /*En este ejemplo, la clave de cifrado es 1. Esto significa que cada letra del
     texto original será desplazada una posición hacia la derecha en el alfabeto para
      obtener el texto encriptado. */

    let textoEncriptado = ''; //es una cadena vacía donde se almacenará el texto encriptado resultante.

    for (let i = 0; i < textoOriginal.length; i++) {
        let charCode = textoOriginal.charCodeAt(i);
        /*Se utiliza un bucle for para iterar sobre cada carácter del texto original.
         textoOriginal.charCodeAt(i) obtiene el código Unicode del carácter en la posición i. */

        // Aplicar el desplazamiento
        if (charCode >= 65 && charCode <= 90) {
            // son las Mayúsculas (A-Z)
            charCode = (charCode - 65 + clave) % 26 + 65;
        } else if (charCode >= 97 && charCode <= 122) {
            // Son las Minúsculas (a-z)
            charCode = (charCode - 97 + clave) % 26 + 97;
        } 
        /*Se verifica si el charCode corresponde a una letra mayúscula (entre 65 y 90 en ASCII)
         o minúscula (entre 97 y 122 en ASCII).
        Si es una letra mayúscula, se aplica el desplazamiento en el alfabeto de A-Z (65 a 90).
        Si es una letra minúscula, se aplica el desplazamiento en el alfabeto de a-z (97 a 122).
        El cálculo (charCode - 65 + clave) % 26 + 65 o (charCode - 97 + clave) % 26 + 97 realiza
        el desplazamiento circular en el alfabeto, donde % 26 asegura que el desplazamiento 
        vuelva al principio después de la 'Z' o 'z'. */
        
        textoEncriptado += String.fromCharCode(charCode);
        /*String.fromCharCode(charCode): Convierte el código ASCII charCode de vuelta a su carácter
         correspondiente. textoEncriptado += ...: Agrega el carácter encriptado al final de la 
         cadena textoEncriptado */
    }

    document.getElementById('resultado').value = textoEncriptado;
    /*document.getElementById('resultado').value: Selecciona el elemento del DOM con id 'resultado'
     (el segundo campo de entrada en nuestro HTML). = textoEncriptado;: Asigna el valor de 
     textoEncriptado al campo de entrada 'resultado', mostrando así el texto encriptado al usuario. */
}

/*
CIFRADO CESAR

El proceso de cifrado se realiza de la siguiente manera:

Se elige una clave, que es un entero entre 0 y 25.
Se sustituye cada letra del mensaje por la letra que se encuentra en la posición correspondiente 
a la clave en el alfabeto. Por ejemplo, si la clave es 1, la letra “A” se sustituye por la letra “B”,
 la letra “B” se sustituye por la letra “C”, y así sucesivamente hasta sustituir la letra “Z” por la 
 letra “A”.
Ejemplo

Supongamos que queremos cifrar el mensaje “HELLO” con una clave de 3. La sustitución se realizaría 
de la siguiente manera:

H -> K (H + 3 = K)
E -> H (E + 3 = H)
L -> O (L + 3 = O)
L -> O (L + 3 = O)
O -> R (O + 3 = R)
El mensaje cifrado sería “KHOOR”.
*/