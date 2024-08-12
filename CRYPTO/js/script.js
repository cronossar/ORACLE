document.getElementById('encryptBtn').addEventListener('click', function() {
    copyBtn.style.display = 'block'; // Muestra el segundo botón
    lupita.style.display = 'none'; // Oculta lupita
    let inputText = document.getElementById('inputText').value;
    let encryptedText = btoa(inputText); // Encriptación básica usando Base64
    document.getElementById('outputText').value = encryptedText;
    document.getElementById('inputText').value = '';
});

document.getElementById('decryptBtn').addEventListener('click', function() {
    let inputText = document.getElementById('inputText').value;
    try {
        let decryptedText = atob(inputText); // Desencriptación básica usando Base64
        document.getElementById('outputText').value = decryptedText;
        document.getElementById('inputText').value = '';
    } catch (e) {
        alert('Texto encriptado inválido');
    }
});

document.getElementById('copyBtn').addEventListener('click', function() {
    let outputText = document.getElementById('outputText');
    outputText.select();
    document.execCommand('copy');
    alert('Copié tu texto encriptado. Ahora pegalo en el otro cuadro para desencriptar');
    // Borrar el texto después de copiar
    outputText.value = '';
});
